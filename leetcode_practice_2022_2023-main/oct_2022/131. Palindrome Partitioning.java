class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(0, res, curr, s);
        return res;
    }

    private void helper(int start, List<List<String>> res , List<String> curr, String s){
        if(start >= s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end=start; end<s.length(); end++){
            //check if it is palindrom, if yes, add to curr
            if(isPalindrome(s, start, end)){
                String str = s.substring(start, end+1);
                curr.add(str);
                //check remaining string
                helper(end+1, res, curr, s);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}