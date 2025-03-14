class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int currMax = 0;

        for(int i=0; i<coins.length; i++){
            //if it is already greater than currMax+1, there is no way that currMax+1 can be created
            if(coins[i] > currMax + 1) break;
            currMax = currMax + coins[i];
        }

        return currMax+1;
    }

}