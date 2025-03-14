class Solution {
    public int largestRectangleArea(int[] heights) {
        //we use monotonic stack to keep entire stack non-increasing
        //we store index in stack for the purpose of calculating width
        Stack<Integer> st = new Stack<>();
        List<Integer> heightsList = new ArrayList<>();

        //insert 0 in the front to always keep stack non-empty
        heightsList.add(0);

        for(int i: heights){
            heightsList.add(i);
        }

        heightsList.add(0); //to calculate every possible rectangles prior to this 0

        int maxArea = 0;

        for(int i=0; i<heightsList.size(); i++){
            if(st.isEmpty() || heightsList.get(st.peek()) < heightsList.get(i)){
                st.push(i);
            }else{
                //always keep a non-increasing stack monotonic stack
                while(!st.isEmpty() && heightsList.get(st.peek()) > heightsList.get(i)){
                    //calculate every possible rectangle area
                    int height = heightsList.get(st.peek());
                    st.pop();
                    int width = i - st.peek() - 1; // -1 means to remove left boundary
                    maxArea = Math.max(maxArea, width * height);
                }
                st.push(i);
            }
        }

        return maxArea;

    }
}