class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length+1];
        dp[0] = true;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length-1];
    }
}