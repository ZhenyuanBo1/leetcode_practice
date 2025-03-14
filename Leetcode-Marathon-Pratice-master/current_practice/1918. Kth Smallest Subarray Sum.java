class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        //using presum
        int[] presum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            presum[i+1] = presum[i] + nums[i];
        }
        //diff in presum gives the subarray sum, find the kth smallest diff
        int left = 0, right = Integer.MAX_VALUE;
        while(left < right){
            int diff = left + (right-left)/2;
            if(countSmallerOrEqual(diff, presum)>=k){
                right = diff;
            }else{
                left = diff+1;
            }
        }

        return left;
    }
    private int countSmallerOrEqual(int diff, int[] presum){
        int j=0;
        int ret = 0;
        for(int i=0; i<presum.length; i++){
            while(j<presum.length && presum[j] - presum[i]<=diff){
                j++;
            }
            ret += j-(i+1);
        }
        return ret;
    }
}