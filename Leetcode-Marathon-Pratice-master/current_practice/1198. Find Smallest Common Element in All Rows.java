class Solution {
    public int smallestCommonElement(int[][] mat) {
        //use binary search to find element
        int min = Integer.MAX_VALUE;
        for(int i=0; i<mat[0].length; i++){
            int target = mat[0][i];
            int count = 0;
            for(int j=1; j<mat.length; j++){
                if(searchValue(j, target, mat) != -1){
                    count += 1;
                }
            }
            if(count == mat.length-1){
                min = Math.min(target, min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int searchValue(int r, int target, int[][] mat){
        int left = 0, right = mat[0].length-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(mat[r][mid] > target){
                right = mid-1;
            }else if(mat[r][mid] < target){
                left = mid + 1;
            }else{
                return mat[r][mid];
            }
        }

        if(left == right && mat[r][left] == target) return mat[r][left];

        return -1;
    }
}