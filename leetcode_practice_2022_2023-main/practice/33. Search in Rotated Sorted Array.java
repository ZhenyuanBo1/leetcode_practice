class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        //using binary search to locate the value
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            //check which section to search
            if(nums[mid]>=nums[0] == target>=nums[0]){
                if(nums[mid] < target){
                    l = mid + 1;
                }else if(nums[mid] > target){
                    r = mid-1;
                }
            }else if(target>=nums[0]){
                r = mid-1;
            }else{
                l = mid + 1;
            }
        }
        
        if(l==r && nums[l] == target) return l;
        
        return -1;
    }
}