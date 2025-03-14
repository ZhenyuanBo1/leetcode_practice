class Solution {
    public void reverseWords(char[] s) {
        int l = 0, r = s.length-1;

        while(l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

        int slow = 0, fast = 0;

        while(fast<s.length){
            if((fast+1<s.length && s[fast+1] == ' ') || fast+1 == s.length){
                int l0 = slow, r0 = fast;
                while(l0 < r0){
                    char temp = s[l0];
                    s[l0] = s[r0];
                    s[r0] = temp;
                    l0++;
                    r0--;
                }
                fast+=2;
                slow = fast;
            }else{
                fast++;
            }
        }
    }
}