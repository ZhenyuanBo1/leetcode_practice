class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_cnt = 0, odd_cnt = 0;
        for(int i: position){
            if(i%2 == 0){
                even_cnt += 1;
            }else{
                odd_cnt += 1;
            }
        }

        return Math.min(even_cnt, odd_cnt);
    }
}