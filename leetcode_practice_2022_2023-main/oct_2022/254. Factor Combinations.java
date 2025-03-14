class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 1) return res;
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, 2, n);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int start, int n){
        if(n<=1){
            if(curr.size() > 1) res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<=n; i++){
            int factor = i;
            if(n % factor == 0){
                curr.add(factor);
                helper(res, curr, i, n/factor);
                curr.remove(curr.size()-1);
            }
        }
    }
}