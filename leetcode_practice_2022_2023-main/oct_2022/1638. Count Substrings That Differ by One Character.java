class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int countSubstrings(String s, String t) {
        int left = 0;
        int total = 0;
        while(left < s.length()){
            int right = left + 1;
            String substr = "";
            int count = 0;
            while(right <= s.length()){
                substr = s.substring(left, right);
                right++;
                if(map.containsKey(substr)){
                    continue;
                }else{
                    if(substr.length() <= t.length()) count += helper(substr, t);
                }
            }
            map.put(substr, count);
            total += count;
            left++;
        }
        return total;
    }
    private int helper(String substr, String t){
        int len = substr.length();
        int left = 0;
        int currCount = 0;
        while(left<t.length()){
            if(left + len > t.length()) break;
            String target = t.substring(left, left + len);
            if(isValid(substr, target)){
                currCount++;
            }
            left++;
        }
        return currCount;
    }
    private boolean isValid(String a, String b){
        char[] aList = a.toCharArray();
        char[] bList = b.toCharArray();

        int countDiff = 0;
        for(int i=0; i<aList.length; i++){
            if(aList[i] != bList[i]) countDiff++;
        }
        return countDiff == 1;
    }
}