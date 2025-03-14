class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total_tank = 0;
        int curr_tank = 0;

        for(int i=0; i<gas.length; i++){
            curr_tank += gas[i] - cost[i];

            if(curr_tank < 0){
                //can't reach this point
                curr_tank = 0;
                start = i+1;
            }

            total_tank += gas[i] - cost[i];
        }

        return total_tank >= 0 ? start : -1;
    }
}