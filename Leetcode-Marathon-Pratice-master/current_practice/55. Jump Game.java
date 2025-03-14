class Solution {
    public boolean canJump(int[] nums) {
        int furthestPoint = 0;

        for(int i=0; i<nums.length; i++){
            if(i > furthestPoint) return false;
            furthestPoint = Math.max(furthestPoint, nums[i] + i);
        }

        return furthestPoint >= nums.length-1
    }
}