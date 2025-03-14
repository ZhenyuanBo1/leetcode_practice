class Solution {
    public int numberOfSteps(int num) {
        StringBuilder sb = new StringBuilder();

        if(num == 0) sb.append("0");

        while(num != 0){
            int rem = num % 2;
            sb.insert(0, rem);
            num = num /2;
        }

        return helper(sb.toString());
    }
    private int helper(String s){
        if(s.equals("0")) return 0;

        if(s.charAt(s.length()-1) == '0'){
            return 1 + helper(s.substring(0, s.length()-1));
        }else{
            return 1 + helper(s.substring(0, s.length()-1) + "0");
        }
    }
}