class Solution {
    public String longestNiceSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        String ans = "";

        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String substr = s.substring(i, j);
                if(isValid(substr)){
                    if(substr.length() > maxLen){
                        maxLen = substr.length();
                        ans = substr;
                    }
                }
            }
        }

        return ans;
    }
    private boolean isValid(String s){
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                char lowerc = Character.toLowerCase(c);
                if(s.indexOf(lowerc) == -1) return false;
            }else{
                char upperc = Character.toUpperCase(c);
                if(s.indexOf(upperc) == -1) return false;
            }
        }
        return true;
    }
}