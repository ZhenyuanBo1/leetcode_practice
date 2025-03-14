class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0;
        for(int i=0; i<s.length();){
            if(s.charAt(i) == 'I'){
                if(i+1 < s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    val += map.get(s.charAt(i+1)) - 1;
                    i+=2;
                }else{
                    val += 1;
                    i++;
                }
            }else if(s.charAt(i) == 'X'){
                if(i+1<s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    val += map.get(s.charAt(i+1)) - 10;
                    i+=2;
                }else{
                    val += 10;
                    i++;
                }
            }else if(s.charAt(i) == 'C'){
                if(i+1<s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    val += map.get(s.charAt(i+1)) - 100;
                    i+=2;
                }else{
                    val += 100;
                    i++;
                }
            }else{
                val += map.get(s.charAt(i));
                i++;
            }
        }

        return val;
    }
}