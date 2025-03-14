class Solution {
    /*
        1. for upper bound, we use right - (right - left)/2;
        2. for lower bound, we use left + (right-left)/2;
    */
    public int[] searchRange(int[] nums, int target) {
        int start = getLowerBound(nums, target);
        int end = getUpperBound(nums, target);

        return new int[]{start, end};
    }
    private int getLowerBound(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int index = -1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid; //need to get the left most index, so we should use right
            }
        }

        if(left == right && nums[left] == target){
            index = left;
        }

        return index;
    }

    private int getUpperBound(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int index = -1;
        while(left < right){
            int mid = right - (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid; //need to get the right most index, so we should use left
            }
        }

        if(left == right && nums[left] == target){
            index = left;
        }

        return index;
    }


}

5, 7, 7, 8, 8, 8, 10