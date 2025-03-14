class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;

        int curr = 1, count = 1, length = nums.length;

        while(curr < nums.length){
            if(nums[curr] == nums[curr-1]){
                count++;
                if(count > 2){
                    nums = overwrite(nums, curr+1);
                    length--;
                    curr--;
                }
            }else{
                count = 1;
            }
            curr++;
        }
        return length;
    }
    private int[] overwrite(int[] nums, int startIndex){
        for(int i = startIndex; i<nums.length; i++){
            nums[i-1] = nums[i];
        }
        return nums;
    }
}