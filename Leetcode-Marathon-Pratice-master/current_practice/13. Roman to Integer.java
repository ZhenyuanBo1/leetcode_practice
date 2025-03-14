class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int[] vals = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int val = map.get(ch);
            vals[i] = val;
        }

        int res = 0;
        for(int i=0; i<s.length();){
            //check if the current val is less than the next val
            if(i+1<s.length() && vals[i] < vals[i+1]){
                res += vals[i+1] - vals[i];
                i+=2;
            }else{
                res += vals[i];
            }
        }

        return res;
    }
}