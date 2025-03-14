class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;

        while(slow<nums.length){
            if(nums[slow] == 0){
                int fast = slow;
                while(fast<nums.length && nums[fast] == 0){
                    fast++;
                }
                if(fast > slow && fast<nums.length){
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                }
            }
            slow++;
        }
    }
}