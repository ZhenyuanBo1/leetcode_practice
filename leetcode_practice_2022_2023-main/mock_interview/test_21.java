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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val > root.val){
            //check right subtree
            TreeNode rightNode = insertIntoBST(root.right, val);
            if(rightNode == null) root.right = new TreeNode(val);

        }else if(val < root.val){
            //check left subtree
            TreeNode leftNode = insertIntoBST(root.left, val);
            if(leftNode == null) root.left = new TreeNode(val);
        }

        return root;
    }
}