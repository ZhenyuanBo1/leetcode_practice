class Solution {
    //using slow and fast pointer to look for a loop
    //slow pointer moves by 1 step, fast moves by 2 steps
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length == 1) return false;

        for(int i=0; i<nums.length; i++){
            int slow = i;
            int fast = getNextIndex(nums, slow);

            //check if both pointers are moving towards the same direction
            while(nums[slow] * nums[fast] > 0){
                if(slow == fast){
                    if(slow == getNextIndex(nums, slow)) break;
                    return true;
                }
                if(nums[fast] * nums[getNextIndex(nums, fast)] < 0) break;
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }
        }

        return false;
    }
    private int getNextIndex(int[] nums, int currIndex){
        int nextIndex = (currIndex + nums[currIndex]) % nums.length;

        if(nextIndex >= 0) return nextIndex;
        else nextIndex += nums.length;
    }
}