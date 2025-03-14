class Solution {
    private Map<Integer, String> map = new HashMap<>();

    public String intToRoman(int num) {
        List<Integer> digits = new ArrayList<>();

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        while(num != 0){
            int rem = num % 10;
            digits.add(0, rem);
            num = num / 10;
        }

        String s = "";

        int size = digits.size();

        for(Integer d: digits){
            int val = d*(int)Math.pow(10, size-1);
            size--;
            if(val == 0) continue;
            if(map.containsKey(val)){
                s += map.get(val);
            }else{
                String strVal = Integer.toString(val);
                if(strVal.length() == 1){
                    if(val < 5){
                        s+=buildStr(1, val);
                    }else{
                        s+="V"+buildStr(1, val-5);
                    }
                }else if(strVal.length() == 2){
                    if(val < 50){
                        s+=buildStr(10, val/10);
                    }else{
                        s+="L" + buildStr(10, (val-50)/10);
                    }
                }else if(strVal.length() == 3){
                    if(val < 500){
                        s+=buildStr(100, val/100);
                    }else{
                        s+="D" + buildStr(100, (val - 500)/100);
                    }
                }else{
                    s+=buildStr(1000, val/1000);
                }
            }
        }

        return s;

    
    }
    private String buildStr(int base, int count){
        String s = "";
        for(int i=0; i<count; i++){
            s += map.get(base);
        }
        return s;   
    }
}