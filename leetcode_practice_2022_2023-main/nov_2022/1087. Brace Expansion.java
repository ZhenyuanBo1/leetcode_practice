class Solution {
    private List<List<Character>> options;
    public String[] expand(String s) {
        this.options = new ArrayList<>();

        for(int i=0; i<s.length();){
            List<Character> currOption = new ArrayList<>();
            if(s.charAt(i) != '{'){
                currOption.add(s.charAt(i));
            }else{
                while(s.charAt(i)!='}'){
                    if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                        currOption.add(s.charAt(i));
                    }
                    i++;
                }
            }
            this.options.add(currOption);
            i++;
        }

        String str = "";
        List<String> res = new ArrayList<>();
        backtrack(str, res, 0);

        String[] ans = new String[res.size()];
        
        Collections.sort(res);
        
        for(int j=0; j<res.size(); j++){
            ans[j] = res.get(j);
        }

        return ans;
    }

    private void backtrack(String s, List<String> res, int index){
        if(s.length() == this.options.size()){
            res.add(s);
            return;
        }

        List<Character> targetOption = this.options.get(index);
        
        for(Character ch: targetOption){
            backtrack(s + ch, res, index+1);
        }
    }
}