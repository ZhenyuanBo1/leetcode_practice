class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, candidates, 0, target);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int currSum, int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }else if(target < 0){
            return;
        }

        for(int i=0; i<candidates.length; i++){
            curr.add(candidates[i]);
            helper(res, curr, candidates, currSum, target-candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}