class Solution {
    public int maximalSquare(char[][] matrix) {
        //we can follow the logic used for LC 84, 85
        //we use monotonic stack to calculate max area for each row in order obtain the ultimate max area
        int res=0;
        int[] heights = new int[matrix[0].length+2];

        for(int i=0; i<matrix.length; i++){
            int k=1;
            for(int j=0; j<matrix[0].length; j++){
                int currVal = Character.getNumericValue(matrix[i][j]);
                if(currVal == 1) heights[k++] += 1;
                else heights[k++] = 0;
            }

            res = Math.max(res, helper(heights));
        }
        return res;
    }

    private int helper(int[] heights){
        Stack<Integer> st = new Stack<>();

        int max = 0;
        for(int i=0; i<heights.length; i++){
            if(st.isEmpty() || heights[st.peek()] < heights[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                    int h = heights[st.peek()];
                    st.pop();
                    int w = i - st.peek() - 1;
                    int side = Math.min(h, w);
                    max = Math.max(max, side * side);
                }
                st.push(i);
            }
        }
        return max;
    }
}