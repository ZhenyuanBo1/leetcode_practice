class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int currsum = 0;

        for(int i=0; i<rolls.length; i++){
            currsum += rolls[i];
        }

        int sum = mean * (n + rolls.length);

        int remainsum = sum - currsum;

        if(remainsum < n || remainsum > n*6){
            return new int[]{};
        }

        int[] ans = new int[n];

        int avg = remainsum / n;
        int offset = remainsum % n;

        for(int i=0; i<n; i++){
            ans[i] = avg;
            if(offset > 0){
                ans[i] += 1;
            }

            offset--;
        }

        return ans;
    }

}