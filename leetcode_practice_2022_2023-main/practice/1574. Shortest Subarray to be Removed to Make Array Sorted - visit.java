class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        /*
        1. remove subarray from the beginning
        2. remove subarray from the end
        3. remove subarray from the middle
        */
        int left = 0, right = arr.length-1, minLen = arr.length-1;

        while(left < arr.length-1 && arr[left] <= arr[left+1]) left++;
        while(right > 0 && arr[right-1] <= arr[right]) right--;

        minLen = Math.min(right, arr.length-left-1); //this compares the length of the subarray from beginning vs from end
        
        // check middle part
        int i = 0, j = right;

        while(i<=left && j<arr.length && i<j){
            if(arr[i]<=arr[j]){
                minLen = Math.min(minLen, j-i-1); // remove the middle part
                i++;
            }else{
                j++;
            }
        }

        return minLen;


    }
}