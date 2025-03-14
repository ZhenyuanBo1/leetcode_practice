class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] rectHeights = new int[matrix[0].length+2];

        int res = 0;
        for(int i=0; i<matrix.length; i++){
            int k=1;
            for(int j=0; j<matrix[0].length; j++){
                int currVal = Character.getNumericValue(matrix[i][j]);
                //this is the key part, whenever it is 0, we override the previous value with 0
                if(currVal == 1){
                    rectHeights[k++] +=1;
                }else{
                    rectHeights[k++] = 0;
                }
            }
            res = Math.max(res, helper(rectHeights));
        }

        return res;
    }
    private int helper(int[] heights){
        Stack<Integer> st = new Stack<>(); //create a monotonic stack which stores index

        int max = 0;
        for(int i=0; i<heights.length; i++){
            if(st.isEmpty() || heights[st.peek()] < heights[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                    int h = heights[st.peek()];
                    st.pop();
                    int w = i - st.peek() - 1;
                    max = Math.max(max, h*w);
                }
                st.push(i);
            }
        }

        return max;
    }
}