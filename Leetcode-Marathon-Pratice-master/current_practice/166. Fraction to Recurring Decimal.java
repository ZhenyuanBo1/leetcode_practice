class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String res = "";

        long num = numerator, denom = denominator;

        if(num == 0) return "0";

        int sign = 1;
        if(num<0){
            sign *= -1;
            num = Math.abs(num);
        }

        if(denom<0){
            sign *= -1;
            denom = Math.abs(denom);
        }

        if(sign == -1) res += "-";

        long val = num/denom;

        res += val;

        long rem = num % denom;

        if(rem !=0 ) {
            res += ".";
        }else{
            return res;
        }

        Map<Long, Integer> map = new HashMap<>();

        int pos = res.length();
        while(rem != 0 && !map.containsKey(rem)){
            map.put(rem, pos);
            res += (rem * 10 / denom);
            rem = (rem * 10) % denom;
            pos += 1;
        }

        if(rem == 0) return res;

        int start = map.get(rem);

        res = res.substring(0, start) + "(" + res.substring(start) + ")";

        return res;
    }
}