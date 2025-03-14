class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<stones.length(); i++){
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        }

        int sum = 0;

        for(char ch: jewels.toCharArray()){
            if(map.containsKey(ch)){
                sum += map.get(ch);
            }
        }

        return sum;
    }
}