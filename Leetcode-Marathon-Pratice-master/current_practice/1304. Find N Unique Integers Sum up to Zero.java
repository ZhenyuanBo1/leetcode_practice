class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];

        int val = n/2;
        int j=n-1;

        for(int i=0; i<n/2; i++){
            arr[i] = -val;
            arr[j] = val;
            val += 1;
            j--;
        }

        return arr;
    }
}


class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];


        for(int i=0; i<n/2; i++){
            int val = (-1) * (n/2) + i;
            arr[i] = val;
            arr[n-1-i] = -val;
        }

        return arr;
    }
}