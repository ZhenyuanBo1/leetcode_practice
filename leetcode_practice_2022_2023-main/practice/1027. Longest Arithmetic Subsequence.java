class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int[] index = new int[1001];
        Arrays.fill(index, -1);
        
        int res = 2;

        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], 2);
            for(int j=i+1; j<nums.length; j++){
                int target = 2*nums[i] - nums[j];
                if(target < 0 || index[target] == -1) continue;
                dp[i][j] = dp[index[target]][i] + 1;
                res = Math.max(res, dp[i][j]);
            }
            index[nums[i]] = i;
        }
        
        return res;
    }
}