class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res, curr, candidates, 0, target);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int[] candidates, int index, int sum){
        if(sum == 0){
            res.add(new ArrayList<>(curr));
            return;
        }else if(sum<0){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(res, curr, candidates, i, sum-candidates[i]); // if it is not i+1, then its going to be the same pos again, which allows unlimited number of usage for the same element
            curr.remove(curr.size()-1);
        }
    }

}