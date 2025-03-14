class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<List<Integer>> st = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        int j=0;

        for(int i=0; i<nums.length; i++){
            if(st.isEmpty() || st.peek().get(0) > nums[i]){
                st.push(Arrays.asList(nums[i], j));
                j++;
            }else{
                while(!st.isEmpty() && st.peek().get(0) < nums[i]){
                    ans[st.peek().get(1)] = nums[i];
                    st.pop();
                }
                st.push(Arrays.asList(nums[i], j));
                ans[j] = -1;
                j++;
            }
        }

        //check any leftover values
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && st.peek().get(0) < nums[i]){
                ans[st.peek().get(1)] = nums[i];
                st.pop();
            }
        }

        return ans;
    }
}