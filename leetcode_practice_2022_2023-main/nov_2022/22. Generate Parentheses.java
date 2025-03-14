class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String curr = "";
        backtrack(res, curr, n, 0, 0);
        return res;
    }
    private void backtrack(List<String> res, String curr, int max, int close, int open){
        if(curr.length() == max * 2){
            res.add(curr);
            return;
        }

        if(open<max){
            backtrack(res, curr + "(", max, close, open+1);
        }

        if(close<open){
            backtrack(res, curr + ")", max, close+1, open);
        }
    }
}