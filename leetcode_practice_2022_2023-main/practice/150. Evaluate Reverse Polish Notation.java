class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String operators = "+/-*";

        for(String token: tokens){
            if(operators.indexOf(token) > -1){
                int val1 = st.pop();
                int val2 = st.pop();
                int newval = 0;
                if(token == "+"){
                    newval = val1 + val2;
                }else if(token == "-"){
                    newval = val1 - val2;
                }else if(token == "*"){
                    newval = val1 * val2;
                }else if(token == "/"){
                    newval = val1 / val2;
                }
                st.push(newval);
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}