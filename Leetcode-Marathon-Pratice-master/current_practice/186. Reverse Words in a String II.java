class Solution {
    public void reverseWords(char[] s) {
        /*
        1. reverse the whole string using two pointer
        2. reverse each word using two pointer again
        */
        int left = 0, right = s.length-1;
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

        int j = 0;
        for(int i=0; i<s.length;){
            while(j+1<s.length && s[j+1]!=' '){
                j++;
            }
            int l = i, r = j;
            while(l<r){
                char temp = s[l];
                s[l++] = s[r];
                s[r--] = temp;
            }
            i = j+2;
            j = i;
        }
    }
}