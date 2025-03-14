class Solution {
    public int myAtoi(String s) {
        String trimmedS = s.trim();
        String value = "";
        boolean isPositive = true;
        boolean hasSeenSign = false;

        for(int i=0; i<trimmedS.length(); i++){
            if((trimmedS.charAt(i) == '-' || trimmedS.charAt(i) == '+') && value.length() == 0){
                if(!hasSeenSign){
                    if(trimmedS.charAt(i) == '-') isPositive = false;
                    hasSeenSign = true;
                }else{
                    break;
                }
            }else if(Character.isDigit(trimmedS.charAt(i))){
                value += trimmedS.charAt(i);
            }else{
                break;
            }
        }

        if(value.equals("")) return 0;

        int len = value.length();

        long res = 0;

        for(int i=0; i<value.length(); i++){
            int currDigit = Character.getNumericValue(value.charAt(i));
            res += currDigit * Math.pow(10, len-1);
            if(isPositive){
                if(res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }else{
                if(-res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            len--;
        }

        return isPositive ? (int)res : -(int)res;
    }
}