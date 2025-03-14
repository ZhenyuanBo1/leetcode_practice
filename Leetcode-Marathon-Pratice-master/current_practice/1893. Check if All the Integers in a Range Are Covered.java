class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        //using difference array
        int[] diff = new int[52];

        for(int[] range: ranges){
            int s = range[0];
            int e = range[1];
            diff[s] += 1;
            diff[e+1] -=1;
        }

        int[] prefix = new int[52];

        int curr = 0;

        for(int i=1; i<prefix.length; i++){
            curr += diff[i];
            prefix[i] = curr;
        }

        for(int i=left; i<=right; i++){
            if(prefix[i] < 1) return false;
        }

        return true;
    }
}