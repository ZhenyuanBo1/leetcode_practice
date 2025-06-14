class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        int left = 0, right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return helper(s, left+1, right) || helper(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }
    private boolean helper(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}