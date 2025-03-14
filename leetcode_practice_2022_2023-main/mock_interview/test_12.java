class Solution {
    private int res;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int currSum = 0;
        List<Integer> curr = new ArrayList<>();
        if(backtrack(currSum, coins, amount, curr)) return this.res;

        return -1;

    }
    private boolean backtrack(int sum, int[] coins, int amount, List<Integer> curr){
        if(sum == amount){
            this.res = curr.size();
            return true;
        }else if(sum > amount){
            return false;
        }

        for(int i=0; i<coins.length; i++){
            curr.add(coins[i]);
            if(backtrack(sum+coins[i], coins, amount, curr)) return true;
        }

        return false;
    }
}