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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0, right = nums.length-1;
        return helper(nums, left, right);
    }

    private TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = left + (right-left)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);

        return root;
    }
}