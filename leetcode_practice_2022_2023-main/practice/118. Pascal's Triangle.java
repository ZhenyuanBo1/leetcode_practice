class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = Arrays.asList(1);
        res.add(level);

        if(numRows == 1) return res;

        List<Integer> curr = Arrays.asList(1, 1);
        res.add(curr);
        
        if(numRows > 2){
            for(int i=3; i<=numRows; i++){
                List<Integer> prev = res.get(res.size()-1);
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for(int j=0; j+1<prev.size(); j++){
                    int sum = prev.get(j) + prev.get(j+1);
                    list.add(sum);
                }
                list.add(1);
                res.add(list);
            }
        }

        return res;
    }
}