class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int left=0;
        int right=0;
        int sum=0;

        while(right<arr.length){
            sum += arr[right++];
            if(right-left == k){
                if(sum/k >= threshold){
                    count += 1;
                }
                sum -= arr[left++];
            }
        }

        return count;
    }
}