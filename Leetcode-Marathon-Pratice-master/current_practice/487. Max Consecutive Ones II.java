class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flip=0, r=0, max=0;

        for(int l=0; l<nums.length; l++){
            while(r<nums.length && (nums[r] == 1 || flip<1)){
                if(nums[r] == 0) flip++;
                r++;
            }
            max = Math.max(max, r-l);
            if(nums[l]==0) flip--;
        }

        return max;
    }
}