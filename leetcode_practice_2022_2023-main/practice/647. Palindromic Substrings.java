class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        //we check if it is palindromic, we expand both left and right until it is not

        for(int i=0; i<s.length(); i++){
            int l=i, r = i;
            //odd length
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }

            //even length
            l=i;
            r=i+1;

            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}