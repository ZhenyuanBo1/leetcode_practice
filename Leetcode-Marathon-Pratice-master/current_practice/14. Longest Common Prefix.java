class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for(int i=1; i<strs.length; i++){
            String currStr = strs[i];
            int endIndex = 0;
            for(int j=0; j<commonPrefix.length(); j++){
                if(j>=currStr.length() || currStr.charAt(j) != commonPrefix.charAt(j)){
                    break;
                }else if(currStr.charAt(j) == commonPrefix.charAt(j)){
                    endIndex++;
                }
            }
            commonPrefix = commonPrefix.substring(0, endIndex);
        }
        return commonPrefix;
    }
}