class Solution {
    public int partitionString(String s) {
        int slow = 0, fast = 0;
        int count = 0;

        while(slow<s.length()){
            String candidate = "";
            while(fast<s.length() && candidate.indexOf(s.charAt(fast)) == -1){
                candidate += s.charAt(fast);
                fast++;
            }
            count++;
            slow = fast;
        }

        return count;
    }
}