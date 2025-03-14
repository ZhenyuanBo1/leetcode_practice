class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            //check which section nums[mid] and target will fall in
            if(nums[mid]>=nums[0] == target>=nums[0]){
                //in the same section
                if(nums[mid] < target){
                    left = mid+1;
                }else if(nums[mid] > target){
                    right = mid-1;
                }
            }else if(target>=nums[0]){
                //in the left group
                right = mid-1;
            }else{
                //in the right group
                left = mid+1;
            }
        }

        //left could be greater or equal to right
        if(left == right && nums[left] == target) return left;

        return -1;
    }
}
