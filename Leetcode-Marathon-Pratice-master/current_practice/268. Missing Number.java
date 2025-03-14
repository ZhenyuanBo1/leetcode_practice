class Solution {
    public int missingNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i && nums[i]<nums.length && nums[i]!=nums[nums[i]]){
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i) return i;
        }

        return nums.length;
    }
}