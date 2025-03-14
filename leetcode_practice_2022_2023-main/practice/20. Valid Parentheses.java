class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!st.isEmpty() && st.peek() == '(') st.pop();
                else return false;
            }else if(s.charAt(i) == '}'){
                if(!st.isEmpty() && st.peek() == '{') st.pop();
                else return false;
            }else if(s.charAt(i) == ']'){
                if(!st.isEmpty() && st.peek() == '[') st.pop();
                else return false;
            }else{
                st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }
}