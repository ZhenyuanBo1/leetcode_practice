class Solution {
    public long subArrayRanges(int[] nums) {
        //for each value in nums, we need to calculate the largest value and smallest value
        int[] nextGreater = new int[nums.length];
        int[] nextSmaller = new int[nums.length];
        int[] prevGreater = new int[nums.length];
        int[] prevSmaller = new int[nums.length];
        Arrays.fill(nextGreater, nums.length);
        Arrays.fill(nextSmaller, nums.length);
        Arrays.fill(prevGreater, -1);
        Arrays.fill(prevSmaller, -1);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(st.isEmpty() || nums[st.peek()] >= nums[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                    nextGreater[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()) st.pop();

        for(int i=nums.length-1; i>=0; i--){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                    prevGreater[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()) st.pop();

        for(int i=0; i<nums.length; i++){
            if(st.isEmpty() || nums[st.peek()] <= nums[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                    nextSmaller[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()) st.pop();

        for(int i=nums.length-1; i>=0; i--){
            if(st.isEmpty() || nums[st.peek()] < nums[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                    prevSmaller[st.peek()] = i;
                    st.pop();
                }
                st.push(i);
            }
        }

        long sum = 0;

        for(int i=0; i<nums.length; i++){
            long val1 = (long)nums[i] * (i - prevGreater[i]) * (nextGreater[i] - i);
            long val2 = (long)nums[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
            sum  = sum + val1 - val2;
        }

        return sum;
    }
}