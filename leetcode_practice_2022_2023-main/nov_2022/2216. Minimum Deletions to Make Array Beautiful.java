class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int delete = 0;
        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0){
                st.push(nums[i]);
            }else{
                if(st.peek() == nums[i]){
                    delete++;
                }else{
                    st.push(nums[i]);
                }
            }
        }

        return st.size() % 2 == 0 ? delete : delete + 1;
    }
}