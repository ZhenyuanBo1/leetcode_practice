class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]%2 == 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        return nums;
    }
}