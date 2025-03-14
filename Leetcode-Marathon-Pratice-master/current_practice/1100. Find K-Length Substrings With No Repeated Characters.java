class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
       int left=0;
       int right=0;
       Set<Character> set = new HashSet<>();
       int count=0;

       while(right<s.length()){
           while(set.contains(s.charAt(right))){
               set.remove(s.charAt(left++));
           }
           set.add(s.charAt(right++));
           if(right-left == k){
               count+=1;
               set.remove(s.charAt(left++));
           }
       }

       return count;
    }
}