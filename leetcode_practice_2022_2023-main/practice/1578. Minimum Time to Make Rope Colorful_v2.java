class Solution {
    class Pair{
        char c;
        int index;
        public Pair(char c, int index){
            this.c = c;
            this.index = index;
        }
    }
    public int minCost(String colors, int[] neededTime) {
        Stack<Pair> st = new Stack<>();
        int cost = 0;

        for(int i=0; i<colors.length(); i++){
            if(st.isEmpty() || colors.charAt(i) != st.peek().c){
                st.push(new Pair(colors.charAt(i), i));
            }else{
                int prevIndex = st.peek().index;
                if(neededTime[prevIndex] < neededTime[i]){
                    //remove prev
                    cost += neededTime[prevIndex];
                    st.pop();
                    st.push(new Pair(colors.charAt(i), i));
                }else{
                    cost += neededTime[i];
                }
            }
        }

        return cost;
    }

}