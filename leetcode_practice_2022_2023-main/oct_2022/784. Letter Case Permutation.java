class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        //build a list ["a", "A"] and the expand it to ["ab", "Ab", "aB", "AB"]
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int n = ans.size();
            if(Character.isLetter(c)){
                for(int i=0; i<n; i++){
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            }else{
                for(int j=0; j<n; j++){
                    ans.get(j).append(c);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(StringBuilder sb: ans){
            res.add(sb.toString());
        }
        return res;
    }
}