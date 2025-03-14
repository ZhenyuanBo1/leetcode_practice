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
    private int count;
    public int goodNodes(TreeNode root) {
        //we need to keep track of curr max
        this.count = 0;
        int currMax = root.val;
        helper(root, currMax);
        return this.count;
    }

    private void helper(TreeNode root, int currMax){
        if(root.val >= currMax){
            currMax = root.val;
            this.count+=1;
        }

        if(root.left != null){
            helper(root.left, currMax);
        }

        if(root.right != null){
            helper(root.right, currMax);
        }
    }
}