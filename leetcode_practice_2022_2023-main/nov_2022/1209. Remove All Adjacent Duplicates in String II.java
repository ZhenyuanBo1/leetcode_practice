class Solution {
    //associate each character with a count of occurence
    class Pair {
        int cnt;
        char ch;
        public Pair(int cnt, char ch) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(st.isEmpty() || s.charAt(i) != st.peek().ch){
                st.push(new Pair(1, s.charAt(i)));
            }else{
                if(++st.peek().cnt == k){
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