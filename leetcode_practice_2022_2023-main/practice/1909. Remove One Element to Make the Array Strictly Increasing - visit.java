class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        int p = 0;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1] || nums[i]==nums[i+1]){
                count++;
                p = i; // p references the point where the value drops
            }
        }

        //count refers to the number of times value drops
        if(count >= 2) return false;

        if(count == 1){
            if(p == 0 || p == nums.length-2) return true;
            if(nums[p+1] > nums[p-1] || nums[p+2] > nums[p]) return true;
            return false;
        }

        return true;
    }
}