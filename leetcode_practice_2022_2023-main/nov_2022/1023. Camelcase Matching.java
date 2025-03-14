class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            String query = queries[i];
            if(isMatch(query, pattern)){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;
    }

    private boolean isMatch(String query, String pattern){
        int p = 0, p1 = 0;

        while(p<query.length()){
            char c = query.charAt(p);
            if(p1<pattern.length() && c == pattern.charAt(p1)){
                p1++;
            }else if(Character.isUpperCase(c)){
                return false;
            }
            p++;
        }
        
        return p1>=pattern.length();
    }
}