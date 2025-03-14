class Solution {
    public int myAtoi(String s) {
        int p1 = 0;
        while(p1<s.length() && s.charAt(p1) == ' '){
            p1++;
        }
        boolean isPositive = true;

        if(p1<s.length()){
            if(!Character.isDigit(s.charAt(p1)) && s.charAt(p1) == '-'){
                isPositive = false;
                p1++;
            }else if(!Character.isDigit(s.charAt(p1)) && s.charAt(p1) == '+'){
                p1++;
            }
        }

        int p2 = p1;

        for(int i=p2; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) break;
            p2++;
        }

        String digitStr = s.substring(p1, p2);

        long val = 0;

        int count = digitStr.length()-1;

        for(int i=0; i<digitStr.length(); i++){
            val += (digitStr.charAt(i) - '0') * Math.pow(10, count);
            if(!isPositive && val > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }else if(isPositive && val > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            count--;
        }

        return isPositive ? (int)val : (-1)*(int)val;
    }
}