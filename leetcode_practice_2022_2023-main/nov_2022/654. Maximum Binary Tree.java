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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //find the maximum value of curr array
        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                maxPos = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);

        //get the left sub array
        int leftLen = maxPos;
        int rightLen = nums.length-maxPos-1;

        if(leftLen > 0){
            int[] leftArray = new int[leftLen];
            for(int i=0; i<leftLen; i++){
                leftArray[i] = nums[i];
            }
            root.left = constructMaximumBinaryTree(leftArray);
        }

        //get the right sub array
        if(rightLen > 0){
            int[] rightArray = new int[rightLen];
            int j=0;
            for(int i=maxPos+1; i<nums.length; i++){
                rightArray[j++] = nums[i];
            }
            root.right = constructMaximumBinaryTree(rightArray);
        }

        return root;
        
    }
}