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

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(mid);
        int[] leftNums = buildArray(nums, 0, mid);
        if(leftNums.length == 0) root.left = null;
        else root.left = sortedArrayToBST(leftNums);

        int[] rightNums = buildArray(nums, mid+1, right);
        if(rightNums.length == 0) root.right = null;
        else root.right = sortedArrayToBST(rightNums);

        return root;

    }
    private int[] buildArray(int[] nums, int start, int end){
        int[] res = new int[end-start];

        int j = 0;
        for(int i = start; i<end; i++){
            res[j++] = nums[i];
        }

        return res;
    }
}