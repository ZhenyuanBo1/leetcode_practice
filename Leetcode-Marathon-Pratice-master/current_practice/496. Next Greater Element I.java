class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<List<Integer>> st = new Stack<>();
        int[] arr = new int[nums2.length];

        int i=0;

        for(int j=0; j<nums2.length; j++){
            int curr = nums2[j];
            if(st.isEmpty()||st.peek().get(0) > curr){
                st.push(Arrays.asList(curr, i));
                i++;
            }else{
                while(!st.isEmpty() && st.peek().get(0) < curr){
                    arr[st.peek().get(1)] = curr;
                    st.pop();
                }
                st.push(Arrays.asList(curr, i));
                arr[i] = 0;
                i++;
            }
        }

        int[] ans = new int[nums1.length];

        for(int k=0; k<nums1.length; k++){
            for(int j=0; j<nums2.length; j++){
                if(nums2[j] == nums1[k]){
                    if(arr[j] == 0){
                        ans[k] = -1;
                    }else{
                        ans[k] = arr[j];
                    }
                }
            }
        }

        return ans;
    }
}