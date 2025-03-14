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
    private Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        this.prev = null;
        this.ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);

        if(this.prev != null){
            this.ans = Math.min(this.ans, root.val - this.prev);
        }

        this.prev = root.val;
        dfs(root.right);
    }


}