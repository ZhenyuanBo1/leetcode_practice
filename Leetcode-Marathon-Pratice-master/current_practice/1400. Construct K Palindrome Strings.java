class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int countOdd = 0

        for(Character ch: map.keySet()){
            if(map.get(ch) % 2 != 0){
                countOdd+=1;
            }
        }

        if(countOdd > k) return false;

        return true;

    }
}