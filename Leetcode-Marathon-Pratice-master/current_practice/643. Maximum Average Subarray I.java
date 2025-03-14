class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int left=0;
        int right=0;
        int sum=0;
        int currMax = Integer.MIN_VALUE ;

        while(right<nums.length){
            if(right-left+1 == k){
                sum += nums[right++];
                currMax = Math.max(currMax, sum);
                sum -= nums[left++];
            }else if(right-left+1 < k){
                sum += nums[right++];
            }
        }

        return (double)currMax / (double)k;
    }
}