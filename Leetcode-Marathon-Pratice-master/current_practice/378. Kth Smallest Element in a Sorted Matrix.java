class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                arr[index++] = matrix[i][j];
            }
        }
        long left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        while(left < right){
            long mid = left + (right-left)/2;
            if(countSmallerOrEqual(mid, arr) >= k){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        int target = (int)left;
        return target;
    }
    private long countSmallerOrEqual(long mid, int[] arr){
        long count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=mid) count+=1;
        }
        return count;
    }
}