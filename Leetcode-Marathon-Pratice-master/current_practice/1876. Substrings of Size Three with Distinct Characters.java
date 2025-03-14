class Solution {
    public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet<>();

        int left=0;
        int right=0;
        int numGoodStr = 0;

        while(right<s.length()){
            if(set.size() == 3){
                numGoodStr += 1;
                set.remove(s.charAt(left++));
            }
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
            }else{
                set.remove(s.charAt(left++));
            }
        }

        return set.size() == 3 ? numGoodStr + 1 : numGoodStr;
    }
}