class Solution {
    public int firstMissingPositive(int[] nums) {
        //using indexing sort
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i+1 && nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        //check the entire array again
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1) return i+1;
        }

        return nums.length+1;

    }
}