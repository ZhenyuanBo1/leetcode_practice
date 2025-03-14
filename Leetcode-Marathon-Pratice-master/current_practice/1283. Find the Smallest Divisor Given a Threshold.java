class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1, right = Integer.MAX_VALUE, minDivisor = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right-left)/2; //mid is the possible candidate for divisor
            if(calculateSum(mid, nums)>threshold){
                left = mid+1;
            }else{
                right = mid;
                minDivisor = Math.min(minDivisor, right);
            }
        }
        return left;
    }

    private int calculateSum(int mid, int[] nums){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            int rem = nums[i] % mid;
            if(rem > 0){
                sum += Math.round(nums[i]/mid + 1);
            }else if(rem == 0){
                sum += nums[i]/mid;
            }
        }
        return sum;
    }
}