class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length-1;

        //to look for the smallest, largest values, we should think about binary search by value approach
        while(left < right){
            int mid = left + (right - left)/2;
            if(isOK(mid, arr)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return arr[left] == left ? left : -1;
    }

    private boolean isOK(int mid, int[] arr){
        return arr[mid] >= mid;
    }
}