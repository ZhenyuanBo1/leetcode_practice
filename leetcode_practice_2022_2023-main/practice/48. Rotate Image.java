class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int count = 0;
        while(count < size){
            int i = count, j = count+1;
            while(j<matrix[0].length){
                int curr = matrix[i][j];
                int val = matrix[j][i];
                int temp = curr;
                matrix[i][j] = val;
                matrix[j][i] = curr;
                j++;
            }
            count++;
        }

        int left = 0, right = matrix[0].length-1;

        int row = 0;
        while(row < matrix.length){
            int l = left, r = matrix[0].length-1;
            while(l<r){
                int val1 = matrix[row][l];
                int val2 = matrix[row][r];
                int temp = val1;
                matrix[row][l] = val2;
                matrix[row][r] = temp;
                l++;
                r--;
            }
            row++;
        }
    }
}