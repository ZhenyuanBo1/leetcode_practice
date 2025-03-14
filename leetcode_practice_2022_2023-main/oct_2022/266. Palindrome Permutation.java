class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[26];
        
        for(int i=0; i<s.length(); i++){
            int index = (int)s.charAt(i) - 97;
            if(arr[index] == 0){
                arr[index] += 1;
            }else if(arr[index] == 1){
                arr[index] -= 1;
            }
        }
        
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1) count++;
        }
        
        if(count > 0) return count == 1;
        
        return true;
    }
}