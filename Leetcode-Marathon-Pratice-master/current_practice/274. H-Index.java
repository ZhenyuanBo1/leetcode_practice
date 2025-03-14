class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int left = 0, right = citations.length-1, n = citations.length;

        while(left < right){
            int mid = left + (right-left)/2;
            if(n-mid > citations[mid]){
                left = mid+1;
            }else if(n-mid < citations[mid]){
                right = mid;
            }else{
                return citations[mid];
            }
        }

        return Math.min(citations[left], n-left);
    }
}