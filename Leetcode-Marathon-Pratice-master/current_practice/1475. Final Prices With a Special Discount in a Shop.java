class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int index = -1;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]<=prices[i]){
                    index = j;
                    break;
                }
            }
            if(index!=-1){
                ans[i] = prices[i]-prices[index];
            }else{
                ans[i] = prices[i];
            }
        }

        return ans;
    }
}