class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if(m*k > bloomDay.length) return -1;

        int left = 1, right = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right-left)/2;
            if(isOK(mid, bloomDay, m, k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isOK(int mid, int[] arr, int m, int k){

        int j=0, i=0;

        while(i<m){
            //check if there is a consecutive sequence
            int count = k;
            while(j<arr.length && count>0 && arr[j]<=mid){
                j++;
                count--;
            }

            if(count == 0){
                i++;
            }else if(j<arr.length && arr[j] > mid){
                j++;
            }else if(j>=arr.length && count > 0){
                return false;
            }
        }


        return true;
    }
}