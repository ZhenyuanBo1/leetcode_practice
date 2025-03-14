class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int maxCount = 0;

        while(right<nums.length){
            if(nums[right] == 0){
                k--;
            }

            if(k < 0){
                k += 1 - nums[left++];
            }

            right++;
        }

        return right-left;
    }
}

class Solution {
    public int longestOnes(int[] nums, int k) {
        int flip=0, r=0, max=0;

        for(int l=0; l<nums.length; l++){
            //find the rightmost boundary
            while(r<nums.length && (nums[r] == 1 || flip<k)){
                if(nums[r] == 0) flip++;
                r++;
            }
            max = Math.max(max, r-l);
            if(nums[l] == 0) flip--;
        }

        return max;
    }
}