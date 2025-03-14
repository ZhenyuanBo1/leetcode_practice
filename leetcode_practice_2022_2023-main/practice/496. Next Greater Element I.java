class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums2.length; i++){
            for(int j=i+1; j<nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        int[] res = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else{
                res[i] = -1;
            }
        }

        return res;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                map.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }

        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }

        int[] res = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
