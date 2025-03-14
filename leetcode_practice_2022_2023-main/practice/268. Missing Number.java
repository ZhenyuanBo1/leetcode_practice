class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;

        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
        }

        return sum - currSum;

    }
}