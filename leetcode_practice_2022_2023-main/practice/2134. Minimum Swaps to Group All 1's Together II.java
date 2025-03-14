class Solution {
    public int minSwaps(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) count++;
        }

        int currCount = 0;
        int min = Integer.MAX_VALUE;

        int slow = 0, fast = 0;

        while(slow < nums.length){
            if(nums[fast%nums.length] == 1) currCount++;
            if(fast-slow+1>=count){
                min = Math.min(min, count - currCount);
                if(nums[slow] == 1) currCount--;
                slow++;
            }
            fast++;
        }

        return min;
    }
}