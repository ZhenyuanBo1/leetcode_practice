class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(mid-1>=0 && arr[mid] < arr[mid-1]){
                right = mid - 1;
            }else if(mid+1<arr.length && arr[mid] < arr[mid+1]){
                left = mid + 1;
            }else if(mid-1>=0 && arr[mid]>arr[mid-1] && mid+1<arr.length && arr[mid] > arr[mid+1]){
                return mid;
            }
        }

        return left;
    }
}