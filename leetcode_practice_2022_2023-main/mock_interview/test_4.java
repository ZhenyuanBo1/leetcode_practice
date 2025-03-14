class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        if(numRows >= 2){
            res.add(Arrays.asList(1, 1));
            for(int i=3; i<=numRows; i++){
                List<Integer> prevLevel = res.get(res.size()-1);
                List<Integer> curr = new ArrayList<>();
                curr.add(1);
                for(int j=0; j+1<prevLevel.size(); j++){
                    curr.add(prevLevel.get(j) + prevLevel.get(j+1));
                }
                curr.add(1);
                res.add(curr);
            }
        }

        return res;
    }
}