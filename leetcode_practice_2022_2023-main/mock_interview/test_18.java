class Solution {
    public int strStr(String haystack, String needle) {
        int j = 0;
        for(int i=0; i<=haystack.length(); i++){
            if(i>=need.length()){
                String substr = haystack.substring(j, i);
                if(substr.equals(needle)) return j;
                j++;
            }
        }

        return -1;
    }
}