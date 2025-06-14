class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right-left);
            if(mid-1>=0 && nums[mid] < nums[mid-1]){
                right = mid-1;
            }else if(mid+1<nums.length && nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                return mid;
            }
        }

        return left;
    }
}