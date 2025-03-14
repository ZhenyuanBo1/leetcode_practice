class Solution {
    //very very very important!!!!!! 
    public int numSteps(String s) {
        /*
        alogrithm:
        1. if the char is 1, set it to 0 and carry should be 1 and stop at char = '0'
        2. if the char is 0, then it is even, we just get rid of that == this is divide by 2
        */
        if(s.equals("1")) return 0;
        //even
        if(s.charAt(s.length()-1) == '0'){
            return 1 + numSteps(s.substring(0, s.length()-1));
        }else{
            int i = s.length()-1;
            StringBuilder sb = new StringBuilder(s);
            while(i>=0){
                if(s.charAt(i) == '0'){
                    sb.setCharAt(i, '1');
                    break;
                }else{
                    sb.setCharAt(i, '0');
                    i--;
                }
            }
            if(i == -1) sb.insert(0, '1');
            return 1 + numSteps(sb.toString());
        }
    }
}


class Solution {
    public int numSteps(String s) {
        /*
        alogrithm:
        1. if the char is 1, set it to 0 - this is equivalent to -1
        2. if the char is 0, then it is even, we just get rid of that == this is divide by 2
        */
        if(s.equals("0")) return 0;
        //even
        if(s.charAt(s.length()-1) == '0'){
            return 1 + numSteps(s.substring(0, s.length()-1));
        }else{
            StringBuilder sb = new StringBuilder(s);
            s.setCharAt(s.length()-1, '0');
            return 1 + numSteps(sb.toString());
        }
    }
}