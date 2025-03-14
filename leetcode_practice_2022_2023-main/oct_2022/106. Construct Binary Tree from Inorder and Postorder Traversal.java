/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
 Algorithm:
 Build hashmap value -> its index for inorder traversal.

 Return helper function which takes as the arguments the left and right boundaries for the current subtree in the inorder traversal. These boundaries are used only to check if the subtree is empty or not. Here is how it works helper(in_left = 0, in_right = n - 1):

    If in_left > in_right, the subtree is empty, return None.

    Pick the last element in postorder traversal as a root.

    Root value has index index in the inorder traversal, elements from in_left to index - 1 belong to the left subtree, and elements from index + 1 to in_right belong to the right subtree.

    Following the postorder logic, proceed recursively first to construct the right subtree helper(index + 1, in_right) and then to construct the left subtree helper(in_left, index - 1).

    Return root.
*/
class Solution {
    int postorderIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return arrayToTree(postorder, 0, inorder.length-1);
    }
    private TreeNode arrayToTree(int[] postorder, int left, int right){
        if(left > right) return null;

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        
        //for postoder, traverse from right -> left
        root.right = arrayToTree(postorder, map.get(rootValue)+1, right);
        root.left = arrayToTree(postorder, left, map.get(rootValue)-1);
        return root;
    }
}