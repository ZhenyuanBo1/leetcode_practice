class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int r=0, max=0;

        for(int l=0; l<nums.length;){
            while(r<nums.length && nums[r] == 1){
                r++;
            }
            max = Math.max(max, r-l);
            while(r<nums.length && nums[r] == 0){
                r++;
            }
            l = r;
        }

        return max;
    }
}