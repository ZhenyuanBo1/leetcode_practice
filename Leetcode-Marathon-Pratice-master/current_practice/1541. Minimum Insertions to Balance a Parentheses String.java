class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int ret = 0;


        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                if(i+1 < s.length() && s.charAt(i+1) == ')'){
                    count--;
                    i++;
                }else{
                    ret++; //insert one
                    count--;
                }
            }
            if(count < 0){
                ret++;
                count = 0;
            }
        }

        ret += count * 2;

        return ret;
    }
}