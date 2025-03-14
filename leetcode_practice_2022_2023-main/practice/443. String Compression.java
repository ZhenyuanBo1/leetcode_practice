class Solution {
    public int compress(char[] chars) {
        int slow = 0;
        StringBuilder sb = new StringBuilder();

        while(slow<chars.length){
            int fast = slow+1;
            char curr = chars[slow];
            while(fast<chars.length && curr == chars[fast]){
                fast++;
            }
            int len = fast - slow;
            if(len == 1){
                sb.append(curr);
            }else{
                sb.append(curr).append(len);
            }
            slow = fast;
        }

        String res = sb.toString();

        for(int i=0; i<res.length(); i++){
            chars[i] = res.charAt(i);
        }

        return res.length();

    }
}

//two pointers: slow & fast pointers 
/*
template: 
1. having external while loop with condition slow < length
2. having fast progress until condition doesn't hold (in while loop) and update slow
*/
