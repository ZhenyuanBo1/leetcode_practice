class Solution {
    public int findKthNumber(int m, int n, int k) {
        //using binary search by value
        int left = 1, right = m*n;

        while(left < right){
            int mid = left + (right-left)/2;
            if(countSmallerOrEqual(mid, m, n) >= k){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    private int countSmallerOrEqual(int mid, int m, int n){
        int count = 0;
        int j = n;
        for(int i=1; i<=m; i++){
            while(j>=1 && i*j>mid){
                j--;
            }
            count += j;
        }
        return count;
    }
}