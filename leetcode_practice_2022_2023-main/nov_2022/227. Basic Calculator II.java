<class Solution {
    public int calculate(String s) {
        //we stop at each operation sign

        Stack<Integer> st = new Stack<>();
        char operation = '+';
        int currVal = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currVal = (currVal * 10) + (ch-'0');
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length()-1){
                if(operation == '-'){
                    st.push(-currVal);
                }else if(operation == '+'){
                    st.push(currVal);
                }else if(operation == '*'){
                    st.push(st.pop() * currVal);
                }else if(operation == '/'){
                    st.push(st.pop() / currVal);
                }
                operation = ch;
                currVal = 0;
            }
        }

        int res = 0;

        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;
    }
}
>