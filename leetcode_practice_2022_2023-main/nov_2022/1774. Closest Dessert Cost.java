class Solution {
    private int res;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.res = baseCosts[0];
        for(int i=0; i<baseCosts.length; i++){
            int baseCost = baseCosts[i];
            backtrack(baseCost, toppingCosts, target, 0);
        }
        return this.res;
    }
    private void backtrack(int curr, int[] toppingCosts, int target, int index){
        if(index>=toppingCosts.length || curr >= target){
            if(Math.abs(curr-target) < Math.abs(this.res-target) || Math.abs(curr-target) == Math.abs(this.res-target) && curr < this.res){
                this.res = curr;
            }
            return;
        }

        backtrack(curr, toppingCosts, target, index+1);
        backtrack(curr + toppingCosts[index], toppingCosts, target, index+1);
        backtrack(curr + toppingCosts[index] * 2, toppingCosts, target, index+1);
    }
}