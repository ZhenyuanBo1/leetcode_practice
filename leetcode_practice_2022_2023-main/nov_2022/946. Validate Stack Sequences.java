class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j=0;

        for(int i=0; i<pushed.length; i++){
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            st.push(pushed[i]);
        }

        while(j<popped.length){
            if(st.peek() == popped[j]){
                st.pop();
                j++;
            }else{
                return false;
            }
        }

        return true;
    }
}