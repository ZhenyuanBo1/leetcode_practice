class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            if(prices[i] > currPrice){
                maxProfit += prices[i] - currPrice;
            }
            currPrice = prices[i];
        }

        return maxProfit;
    }
}