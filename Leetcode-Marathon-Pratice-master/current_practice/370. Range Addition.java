class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //利用差分
        int[] diff = new int[length+1];

        for(int[] update: updates){
            int s = update[0];
            int e = update[1];
            diff[s] += update[2];
            diff[e+1] -= update[2];
        }

        int curr = 0;

        int[] res = new int[length];

        for(int i=0; i<length; i++){
            curr += diff[i];
            res[i] = curr;
        }

        return res;
    }
}