class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right-left)/2;
            if(isOK(mid, weights, days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean isOK(int mid, int[] weights, int days){
        int j = 0;
        for(int i=0; i<days; i++){
            int sum = 0;
            while(j<weights.length && sum+weights[j]<=mid){
                sum += weights[j];
                j++;
            }
        }

        if(j<weights.length) return false; //still have some weights left

        return true;

    }
}