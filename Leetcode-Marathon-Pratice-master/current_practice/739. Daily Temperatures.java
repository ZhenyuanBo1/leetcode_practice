class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<List<Integer>> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        int j=0;
        for(int i=0; i<temperatures.length; i++){
            if(st.isEmpty() || st.peek().get(0) > temperatures[i]){
                st.push(Arrays.asList(temperatures[i], j));
                j++;
            }else{
                while(!st.isEmpty() && st.peek().get(0) < temperatures[i]){
                    ans[st.peek().get(1)] = j-st.peek().get(1);
                    st.pop();
                }
                st.push(Arrays.asList(temperatures[i], j));
                j++;
            }
        }

        return ans;
    }
}