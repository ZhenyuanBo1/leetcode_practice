class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        //using two pointer
        //break the array into three portions: [0:i] [i+1:j-1] [j:n-1]
        int res = arr.length-1;

        //find the j where it is the starting point of non-decreasing portion of arr
        int j = arr.length-1;
        while(j>=1 && arr[j-1]<=arr[j]) j--;

        res = Math.min(res, j);
        if(res == 0) return 0;

        for(int i=0; i<arr.length; i++){
            //we need to make sure [0:i] is increasing as well
            if(i-1>=0 && arr[i-1]>arr[i]) break;
            while(j<arr.length && arr[j]<arr[i]) j++;
            res = Math.min(res, j-i-1);
        }

        return res;
    }
}