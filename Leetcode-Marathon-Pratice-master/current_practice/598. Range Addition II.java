class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //we can actually calculate the number of elements in the overlapping area after all the ops
        for(int[] op: ops){
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }

        return m*n;
    }
}