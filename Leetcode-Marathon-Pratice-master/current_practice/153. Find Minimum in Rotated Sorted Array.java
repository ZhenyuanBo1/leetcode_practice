class Solution {
    public int findMin(int[] nums) {
        long left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;

        while(left < right){
            long mid = left + (right-left)/2;
            if(isOK(mid, nums)){
                right = mid;
            }else{
                left =  mid + 1;
            }
        }

        return (int)left;
    }

    private boolean isOK(long mid, int[] nums){
        int countLess = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= mid){
                countLess+=1;
            }
        }

        return countLess >= 1;
    }
}

//using binary search
class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            //check which section we should perform binary search
            if(nums[mid]>=nums[0] && nums[nums.length-1]<=nums[0]){
                //the minimum should be in the right branch
                left = mid + 1;
            }else if(nums[mid]>=nums[0] && nums[nums.length-1]>=nums[0]){
                return nums[0];
            }else{
                right = mid;
            }
        }

        return nums[left];
    }
}