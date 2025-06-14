class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        if(left == right && nums[left] == target) return left;

        if(nums[left] > target) return left;
        if(nums[left] < target) return left+1;

        return -1;
    }
}