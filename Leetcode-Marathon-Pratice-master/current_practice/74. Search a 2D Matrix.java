class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = -1;
        for(int i=0; i<matrix.length; i++){
            if(target <= matrix[i][matrix[0].length-1]){
                r = i;
                break;
            }
        }

        if(r == -1) return false;

        int left = 0, right = matrix[0].length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(matrix[r][mid]<target){
                left = mid + 1;
            }else if(matrix[r][mid] > target){
                right = mid-1;
            }else{
                return true;
            }
        }

        if(left == right && matrix[r][left] == target) return true;

        return false;
    }
}