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
        countGoodNodes(root, root.val);
        return count;
    }
    private void countGoodNodes(TreeNode root, int currMax){
        int max = root.val >= currMax ? root.val : currMax;
        if(root.val >= currMax) count++;
        if(root.left != null){
            countGoodNodes(root.left, max);
        }
        if(root.right != null){
            countGoodNodes(root.right, max);
        }
    }
}