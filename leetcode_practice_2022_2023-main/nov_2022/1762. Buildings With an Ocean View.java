class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        List<Integer> indices = new ArrayList<>();

        for(int i=heights.length-1; i>=0; i--){
            int height = heights[i];
            while(!st.isEmpty() && heights[st.peek()] < height){
                //remove everything less than the current height
                st.pop();
            }

            if(st.isEmpty()){
                indices.add(i);
            }
            st.push(i);
        }

        int[] arr = new int[indices.size()];

        int j=0;
        for(int i=indices.size()-1; i>=0; i--){
            arr[j++] = indices.get(i);
        }

        return arr;
    }
}