class Solution {
    private int count;
    public int coinChange(int[] coins, int amount) {
        this.count = Integer.MAX_VALUE;
        List<Integer> curr = new ArrayList<>();
        backtrack(coins, curr, amount);
        return this.count;
    }

    private void backtrack(int[] coins, List<Integer> curr, int amount){
        if(amount == 0){
            this.count = Math.min(this.count, curr.size());
            return;
        }else if(amount < 0){
            return;
        }

        for(int i=0; i<coins.length; i++){
            curr.add(coins[i]);
            backtrack(coins, curr, amount-coins[i]);
            curr.remove(curr.size()-1);
        }
    }
}