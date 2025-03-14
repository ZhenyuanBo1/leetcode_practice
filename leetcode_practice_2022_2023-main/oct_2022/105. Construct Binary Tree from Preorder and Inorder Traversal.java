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
class Solution {
    int preorderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    //target array is inorder
    private TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, map.get(rootValue)-1);
        root.right = arrayToTree(preoder, map.get(rootValue)+1, right);
        return root;
    }
}