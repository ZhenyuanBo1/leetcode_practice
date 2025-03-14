class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length-1, n = citations.length;

        while(left < right){
            int mid = left + (right-left)/2;
            if(n-mid >= nums[mid])
        }
    }
}