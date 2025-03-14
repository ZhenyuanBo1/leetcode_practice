class Solution {
    public void sortColors(int[] nums) {
        /*
        1. using three pointers to define the boundary of 0 and 2
        2. if current value is 2, we just place it in the 2 block
        3. if current value is 0, we just place it in the 0 block
        */
        int p0 = 0, curr = 0, p2 = nums.length-1;
        while(curr<=p2){
            if(nums[curr] == 0){
                //put that in the 0 block
                int temp = nums[p0];
                nums[curr++] = temp;
                nums[p0] = 0;
                p0++;
            }else if(nums[curr] == 2){
                int temp = nums[p2];
                nums[curr] = temp;
                nums[p2] = 2;
                p2--;
            }else curr++;
        }
    }
}