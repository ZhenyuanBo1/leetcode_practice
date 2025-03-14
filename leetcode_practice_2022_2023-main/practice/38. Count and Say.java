class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";

        String res = countAndSay(n-1);

        int slow = 0;

        StringBuilder sb = new StringBuilder();

        while(slow < res.length()){
            int fast = slow+1;
            char curr = res.charAt(slow);
            while(fast < res.length() && res.charAt(fast) == curr){
                fast++;
            }
            int len = fast - slow;
            sb.append(len).append(curr);
            slow = fast;
        }

        return sb.toString();
    }
}