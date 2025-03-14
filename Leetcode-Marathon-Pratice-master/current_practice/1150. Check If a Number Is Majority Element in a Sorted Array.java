class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        //calculate the upper bound
        int left = 0, right = nums.length-1, lowerBound = -1, upperBound = -1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left == right && nums[left] == target){
            lowerBound = left;
        }else{
            return false;
        }

        left = 0;
        right = nums.length-1;

        while(left < right){
            int mid = right - (right - left)/2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        upperBound = left;

        int diff = upperBound - lowerBound + 1;

        return diff > nums.length / 2;
    }
}