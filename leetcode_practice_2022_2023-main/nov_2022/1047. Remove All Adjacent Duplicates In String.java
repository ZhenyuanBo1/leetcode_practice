class Solution {
    class Pair{
        int cnt;
        char ch;
        public Pair(int cnt, char ch){
            this.cnt = cnt;
            this.ch = ch;
        }
    }
    public String removeDuplicates(String s) {
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(st.isEmpty() || st.peek().ch != s.charAt(i)){
                st.push(new Pair(1, s.charAt(i)));
            }else{
                if(++st.peek().cnt == 2){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            Pair p = st.pop();
            for(int i=0; i<p.cnt; i++){
                sb.insert(0, p.ch);
            }
        }

        return sb.toString();
    }
}