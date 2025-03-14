class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;

        while(numBottles/numExchange != 0){
            int n = numBottles / numExchange;
            int m = numBottles % numExchange;
            numBottles = n + m;
            res += n;
        }

        return res;


    }
}