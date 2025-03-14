class Solution {
    public int maximumScore(int[] nums, int k) {
        int l = k, r = k;
        int minVal = nums[k];
        int max = Integer.MIN_VALUE;

        while(l>=0 || r<nums.length){
            //check the position where l can be moved to while keeping the minval the same
            while(l>=0 && nums[l]>=minVal) l--;
            while(r<nums.length && nums[r]>=minVal) r++;
            //calculate the latest max score of good array
            max = Math.max(max, minVal*(r-l-1));
            //calculate the latest minVal, pick the larger one between nums[l] and nums[r]
            minVal = Math.max(l>=0 ? nums[l] : Integer.MIN_VALUE, r<nums.length ? nums[r] : Integer.MIN_VALUE);
        }

        return max;
    }
}