class Solution {
    public String reversePrefix(String word, char ch) {
        char[] c = word.toCharArray();

        int end = -1;
        for(int i=0; i<c.length; i++){
            if(c[i] == ch){
                end = i;
                break;
            }
        }

        int left = 0, right = end;

        while(left < right){
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }

        String res = "";

        for(char c1: c){
            res += c1;
        }

        return res;
    }
}