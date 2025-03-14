class Solution {
    public int uniquePaths(int m, int n) {
        //using dynamic programming 求方案总数类问题
        //state:
        int[][] dp = new int[m][n];

        //initialize 
        for(int i=0; i<n; i++){
            dp[0][i] = 1;
        }

        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        //function
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}