class Solution {
    public int maxLength(int[] ribbons, int k) {

        int left = 0, right = Integer.MAX_VALUE;


        while(left < right){
            int mid = right - (right-left)/2;
            if(isOK(mid, ribbons, k)){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        return left;
    }

    private boolean isOK(int mid, int[] ribbons, int k){
        int countRibbons = 0;
        for(int i=0; i<ribbons.length; i++){
            countRibbons += ribbons[i] / mid;
        }
        if(countRibbons >= k) return true;

        return false;
    }
}