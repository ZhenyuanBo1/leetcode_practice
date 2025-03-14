class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int profit = 0;

        for(int i=0; i<prices.length; i++){
            if(st.isEmpty() || prices[i] < st.peek()){
                st.push(prices[i]);
            }else{
                profit += prices[i] - st.peek();
                st.pop();
                st.push(prices[i]);
            }
        }

        return profit;
    }
}