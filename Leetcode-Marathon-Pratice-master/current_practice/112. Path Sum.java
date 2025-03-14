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
    private int sum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode root, int currSum, int targetSum){
        if(root != null){
            currSum += root.val;
            if(root.left == null && root.right == null){
                if(currSum == targetSum) return true;
                else return false;
            }
            boolean checkLeft = dfs(root.left, currSum, targetSum);
            boolean checkRight = dfs(root.right, currSum, targetSum);
            if(checkLeft || checkRight) return true;
        }
        
        return false;
    }
}