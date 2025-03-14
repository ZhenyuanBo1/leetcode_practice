class Solution {
    public int longestOnes(int[] nums, int k) {
        //we need to maintain a window where it contains k 0s

        /*
        In any sliding window based problem we have two pointers. 
        One right pointer whose job is to expand the current window and then we have the left pointer whose job is to 
        contract a given window. 
        At any point in time only one of these pointers move and the other one remains fixed.
        */

        int left = 0, right;

        for(right = 0; right<nums.length; right++){
            if(nums[right] == 0) k--;
            if(k<0){
                k+=1-nums[left++];
            }
        }

        return right - left;

    }
}