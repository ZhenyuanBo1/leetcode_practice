class Solution {
    public String longestPalindrome(String s) {
        // starting from the middle of the string and expand outwards on both sides
        int max = 0;
        String res = "";
        for(int i=0; i<s.length(); i++){
            int l = i, r = i;
            //odd length
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    max = r-l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            //even length
            l = i; 
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    max = r-l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return res;
    }

}