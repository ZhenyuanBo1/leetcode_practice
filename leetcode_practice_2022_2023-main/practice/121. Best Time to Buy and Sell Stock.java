class Solution {
    public int maxProfit(int[] prices) {
        int slow = 0;
        int max = 0;

        while(slow < prices.length){
            int fast = slow + 1;
            while(fast<prices.length && prices[fast] > prices[slow]){
                max = Math.max(max, prices[fast] - prices[slow]);
                fast++;
            }
            slow++;
        }

        return max;
    }
}