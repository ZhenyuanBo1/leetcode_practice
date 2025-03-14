class Solution {
    public int maxRepOpt1(String text) {
        int slow = 0, fast = 0;
        int maxLen = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<text.length(); i++){
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }

        //two pointer method
        while(slow < text.length()){
            int lastUnique = slow;
            int count = 0;
            while(fast < text.length() && text.charAt(fast) == text.chatAt(slow)){
                fast++;
                count++;
            }

            lastUnique = fast;

            //if there is more character left to swap, we perform the swap
            if(map.get(text.charAt(slow)) - cout > 0){
                fast++;
            }

            while(fast < text.length() && text.charAt(fast) == text.charAt(slow)){
                fast++;
            }

            int res = Math.min(fast-slow, map.get(text.charAt(slow)));
            maxLen = Math.max(maxLen, res);

            fast = lastUnique;
            slow = lastUnique;
        }

        return maxLen;
    }
}s