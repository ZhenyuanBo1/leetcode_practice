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
    private int val;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return val;
    }
    private void dfs(TreeNode root, int currNumber){
        if(root != null){
            //using left shift calculates the decimal value
            currNumber = (currNumber << 1) | root.val;
            if(root.left == null && root.right == null){
                val += currNumber;
            }
            dfs(root.left, currNumber);
            dfs(root.right, currNumber);
        }
    }
}