class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, curr, candidates, 0, target);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int index, int currTarget){
        if(currTarget == 0){
            if(!res.contains(curr)) res.add(new ArrayList<>(curr));
            return;
        }else if(currTarget < 0){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue; //avoid duplicates using index
            int val = candidates[i];
            curr.add(val);
            helper(res, curr, candidates, i+1, currTarget-val);
            curr.remove(curr.size()-1);
        }
    }
}