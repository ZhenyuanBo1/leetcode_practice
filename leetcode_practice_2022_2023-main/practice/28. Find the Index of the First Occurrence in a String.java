class Solution {
    //using sliding window
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int len = needle.length();

        int p2 = 0, p1 = 0;

        while(p2 < haystack.length()){
            while(p2-p1+1<len){
                p2++;
            }
            String substr = haystack.substring(p1, p2+1);
            if(substr.equals(needle)) return p1;
            p1++;
            p2++;
        }

        return -1;
    }
}