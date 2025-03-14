class Solution {
    public int minOperations(int n) {
        int end = 2*(n-1)+1;
        int sum = (1+end)*n/2;
        int target = sum / n;

        int ans = 0;

        for(int i=0; i<n/2; i++){
            ans += target - (2*i+1);
        }

        return ans;
    }
}