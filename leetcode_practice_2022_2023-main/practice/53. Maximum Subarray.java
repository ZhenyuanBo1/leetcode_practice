class Solution {
    //frequency 8 - Divide and Conquer
    public int maxSubArray(int[] nums) {
        int currsum = nums[0];
        int maxsum = nums[0];

        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            //if currsum is negative, then we reset it
            currsum = Math.max(num, currsum+num);
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum;
    }
}