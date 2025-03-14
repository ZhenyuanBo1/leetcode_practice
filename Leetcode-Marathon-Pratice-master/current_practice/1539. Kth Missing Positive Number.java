class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 1, right = arr[arr.length-1]+k;
        while(left < right){
            int mid = right-(right-left)/2;
            if(countMissing(mid, arr)>k-1){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        return left;
    }

    private int countMissing(int mid, int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < mid){
                count += 1;
            }
        }
        int missing = mid - 1 - count;
        return missing;
    }
}