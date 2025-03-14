class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int ref = 0, curr = 1;

        while(curr<nums.length){
            if(nums[curr]==nums[ref]){
                curr++;
            }else{
                nums[++ref] = nums[curr];
                curr++;
            }
        }

        return ref+1;
    }
}