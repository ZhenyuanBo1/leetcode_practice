class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //运用差分数组
        int[] diff = new int[n+2];

        for(int[] booking: bookings){
            int s = booking[0];
            int e = booking[1]+1;
            diff[s] += booking[2];
            diff[e] -= booking[2];
        }

        int curr = 0;

        int[] res = new int[n];

        for(int i=1; i<=n; i++){
            curr += diff[i];
            res[i-1] = curr;
        }

        return res
    }
}