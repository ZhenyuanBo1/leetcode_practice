class Solution {
    private int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        for(int i=0; i<matrix.length; i++){
            int start = matrix[i][0];
            int end = matrix[i][matrix[0].length-1];
            if(target>=start && target<=end){
                if(binarySearch(0, matrix[0].length-1, i, matrix[i], target)) return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int l, int r, int rIndex, int[] row, int target){
        while(l<r){
            int mid = l + (r-l)/2;
            if(row[mid] > target){
                r = mid - 1;
            }else if(row[mid] < target){
                l = mid + 1;
            }else if(row[mid] == target){
                return true;
            }
        }
        if(l == r && row[l] == target) return true;
        if(row[l] > target) return false;
        int len = matrix.length-rIndex;
        int[] col = new int[len];
        int j=0;
        for(int i=rIndex; i<matrix.length; i++){
            col[j++] = this.matrix[i][l];
        }
        return binarySearchCol(0, col.length-1, col, target);
    }

    private boolean binarySearchCol(int l, int r, int[] col, int target){
        while(l<r){
            int mid = l + (r-l)/2;
            if(col[mid] > target){
                r = mid - 1;
            }else if(col[mid] < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        if(l==r && col[l] == target) return true;
        return false;
    }
}