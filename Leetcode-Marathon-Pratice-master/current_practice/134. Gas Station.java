class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //we need to check if we have enough gas to travel around
        int sum = 0;
        for(int i=0; i<gas.length; i++){
            sum += gas[i] - cost[i];
        }
        if(sum < 0) return -1;

        sum = 0;
        int res = 0;

        for(int i=0; i<gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                res = i+1;
            }
        }

        return res;
    }
}