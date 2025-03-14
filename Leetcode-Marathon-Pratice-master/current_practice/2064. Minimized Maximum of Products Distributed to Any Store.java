class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right-left)/2;
            if(isOK(mid, n, quantities)){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    private boolean isOK(int mid, int n , int[] quantities){
        int storeCount = 0;
        for(int i=0; i<quantities.length; i++){
            if(quantities[i] % mid == 0){
                storeCount += quantities[i] / mid;
            }else{
                storeCount += quantities[i] / mid + 1;
            }
        }
        if(storeCount <= n) return true;

        return false;
    }
}