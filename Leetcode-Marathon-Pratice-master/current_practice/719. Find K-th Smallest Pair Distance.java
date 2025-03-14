class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); //sort in the ascending order, similar to presums
        int left = 0, right = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right-left)/2;
            if(countSmallerOrEqual(mid, nums) >= k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private int countSmallerOrEqual(int mid, int[] nums){
        int j=0;
        int ret = 0;
        for(int i=0; i<nums.length; i++){
            while(j<nums.length && nums[j] - nums[i] <= mid){
                j++;
            }
            ret += j-(i+1);
        }
        return ret;
    }
}