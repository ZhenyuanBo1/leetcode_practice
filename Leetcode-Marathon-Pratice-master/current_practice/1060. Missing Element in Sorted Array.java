class Solution {

    public int missingElement(int[] nums, int k) {

        int left = nums[0], right = nums[nums.length-1] + k;

        while(left < right){
            int mid = right - (right-left)/2;
            if(countMissing(mid, nums)>=k){
                right = mid-1;
            }else{
                left  = mid;
            }
        }

        return left;
    }

    private int countMissing(int mid, int[] nums){
        int count = 0, missing=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]<mid){
                count += 1;
            }else{
                break;
            }
        }

        missing = mid - nums[0] - count;

        // System.out.println("mid: " + mid + " missing: " + missing);

        return missing;


    }
}