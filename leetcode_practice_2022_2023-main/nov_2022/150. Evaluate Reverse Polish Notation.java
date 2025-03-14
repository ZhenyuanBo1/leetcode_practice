class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];
            if("+-*/".indexOf(token) > -1){
                //start poping up
                int val1 = st.pop();
                int val2 = st.pop();

                int newVal = 0;

                if(token.equals("+")){
                    newVal = val1 + val2;
                }else if(token.equals("-")){
                    newVal = val2 - val1;
                }else if(token.equals("*")){
                    newVal = val1 * val2;
                }else if(token.equals("/")){
                    newVal = val2 / val1;
                }
                st.push(newVal);
            }else{
                st.push(Integer.valueOf(token));
            }
        }

        return st.pop();
    }
}