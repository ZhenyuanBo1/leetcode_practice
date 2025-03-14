class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                l = Math.min(l,st.pop());
            }
            st.push(i);
        }

        st.clear();

        for(int j=nums.length-1; j>=0; j--){
            while(!st.isEmpty() && nums[st.peek()] < nums[j]){
                r = Math.max(r, st.pop());
            }
            st.push(j);
        }

        return r-l>0 r-l+1 : 0;
    }
}