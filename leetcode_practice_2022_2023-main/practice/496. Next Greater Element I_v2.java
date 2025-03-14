class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length];
        Arrays.fill(arr, -1);

        Stack<Integer> st = new Stack<>();
        st.push(nums2[0]);

        List<Integer> nums2List = new ArrayList<>();
        for(int i: nums2){
            nums2List.add(i);
        }

        for(int i=1; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                int index = nums2List.indexOf(st.peek());
                arr[index] = nums2[i];
                st.pop();
            } 
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        List<Integer> list = new ArrayList<>();

        for(int i: arr){
            list.add(i);
        }

        for(int i=0; i<nums1.length; i++){
            int index = nums2List.indexOf(nums1[i]);
            ans[i] = list.get(index);
        }

        return ans;
    }
}