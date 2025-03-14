class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        boolean isPositive = true;
        boolean ignoreZero = true;
        String res="";

        for(int i=0; i<s.length(); i++){
            if(i==0 && !Character.isDigit(s.charAt(i))){
                if(s.charAt(i)=='-'){
                    isPositive = false;
                }else if(s.charAt(i)!='-' && s.charAt(i)!='+'){
                    return 0;
                }
            }else{
                if(!Character.isDigit(s.charAt(i))){
                    break;
                }else{
                    if(s.charAt(i)!='0'){
                        ignoreZero = false;
                        res+=s.charAt(i);
                    }else if(s.charAt(i)=='0' && !ignoreZero){
                        res+=s.charAt(i);
                    }
                }
            }
        }

        if(res=="") return 0;

        if(res.length() > 10){
            if(!isPositive) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        long val = Long.parseLong(res);

        if(!isPositive) val = (-1)*val;

        int finalVal = 0;

        if(val < Integer.MIN_VALUE){
            finalVal = Integer.MIN_VALUE;
        }else if(val > Integer.MAX_VALUE){
            finalVal = Integer.MAX_VALUE;
        }else{
            finalVal = (int)val;
        }

        return finalVal;
    }
}