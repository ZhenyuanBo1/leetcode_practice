class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[mid+1]){
                l = mid+1;
            }else if(nums[mid] < nums[mid+1]){
                return Math.min(nums[l], help(nums, mid, r));
            }
        }

        if(l == r) return nums[l];

        return -1;
    }



    private int help(int[] nums, int l, int r){
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[mid+1]){
                l = mid+1;
            }else if(nums[mid] < nums[mid+1]){
               return Math.min(nums[l], help(nums, mid, r));
            }
        }
        if(l == r) return nums[l];

        return -1;
    }
}