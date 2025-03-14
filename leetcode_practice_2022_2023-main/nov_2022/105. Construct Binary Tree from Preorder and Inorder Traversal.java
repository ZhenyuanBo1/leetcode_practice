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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //build inorder map
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);

    }

    private TreeNode helper(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootVal = preorder[preorder++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, left, inorderMap.get(root)-1);
        root.right = helper(preorder, inorderMap.get(root)+1, right);
        return root;
    }

}