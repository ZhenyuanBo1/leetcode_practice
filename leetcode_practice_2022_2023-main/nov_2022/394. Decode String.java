class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ']'){
                //get the string
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '['){
                    sb.insert(0, st.pop());
                }

                String str = sb.toString();

                st.pop(); // remove '['
                int base = 1;
                int currVal=0;
                //build numeric value
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    char c = st.pop();
                    currVal = currVal + Character.getNumericValue(c) * base;
                    base *= 10;
                }
                String finalStr = "";
                while(currVal>0){
                    finalStr += str;
                    currVal--;
                }
                for(char ch: finalStr.toCharArray()){
                    st.push(ch);
                }
            }else{
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()){
            res.insert(0, st.pop());
        }

        return res.toString();
    }
}