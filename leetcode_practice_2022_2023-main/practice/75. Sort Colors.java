class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1, curr = 0;

        while(curr <= p2){
            if(nums[curr] == 0){
                int tmp = nums[curr];
                nums[curr++] = nums[p0];
                nums[p0++] = tmp;
            }else if(nums[curr] == 2){
                int tmp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr] = tmp;
            }else{
                curr++;
            }
        }
    }
}