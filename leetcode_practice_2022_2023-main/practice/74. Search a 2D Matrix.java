class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int[] row = matrix[i];
            if(target >= row[0] && target <= row[row.length-1]){
                return search(row, target);
            }
        }

        return false;
    }
    private boolean search(int[] row, int target){
        int l = 0, r = row.length-1;

        while(l < r){
            int mid = l + (r-l)/2;

            if(row[mid] > target){
                r = mid-1;
            }else if(row[mid] < target){
                l = mid+1;
            }else{
                return true;
            }
        }

        if(l == r && row[l] == target) return true;

        return false;
    }
}