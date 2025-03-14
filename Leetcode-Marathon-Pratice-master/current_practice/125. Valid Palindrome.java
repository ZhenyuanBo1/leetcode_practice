class Solution {
    public boolean isPalindrome(String s) {
        String modified = s.toLowerCase();
        String modified1 = "";

        for(int i=0; i<modified.length(); i++){
            if(Character.isLetterOrDigit(modified.charAt(i))){
                modified1+=modified.charAt(i);
            }
        }

        int left = 0, right = modified1.length()-1;

        while(left < right){
            if(modified1.charAt(left) != modified1.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }

        return true;
    }
}