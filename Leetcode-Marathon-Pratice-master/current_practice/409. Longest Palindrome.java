class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int len = 0;
        int flag = 0;

        for(Character key : map.keySet()){
            if(map.get(key) % 2 == 0){
                len += map.get(key);
            }else{
                len += map.get(key)-1; // if it is an odd, we convert that to even value
                flag = 1; // we can place this one in the middle
            }
        }


        return len + flag;
    }
}