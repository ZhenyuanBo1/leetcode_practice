class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        helper(list, res, curr, 0, k);
        return res;
    }
    //using index to remove duplicates
    private void helper(List<Integer> list, List<List<Integer>> res, List<Integer> curr, int index, int k){
        if(k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<list.size(); i++){
            if(curr.contains(list.get(i))) continue;
            curr.add(list.get(i));
            helper(list, res, curr, i, k-1);
            curr.remove(curr.size()-1);
        }
    }   
}