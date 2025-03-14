class Solution {
    public int scoreOfParentheses(String s) {
        //maintain the score at each depth
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(0);
            }else{
                int score1 = st.pop();
                int score2 = st.pop();
                int newScore = score2 + Math.max(2*score1, 1);
                st.push(newScore);
            }
        }

        return st.pop();
    }
}