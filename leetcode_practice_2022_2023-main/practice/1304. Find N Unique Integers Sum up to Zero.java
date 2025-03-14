class Solution {
    public int[] sumZero(int n) {
        int [] arr = new int[n];

        int negStart = -1;
        int i=0;

        while(i<n/2){
            arr[i++] = negStart--;
        }

        int posStart = -negStart-1;

        while(i<n){
            arr[i++] = posStart--;
        }

        return arr;
    }
}

class Solution {
    public int[] sumZero(int n) {
        int left = 0, right = n-1;

        int[] res = new int[n];

        int i = 0;

        while(left < right){
            int num1 = -n;
            int num2 = n;
            res[i] = num1;
            res[i+1] = num2;
            n--;
            left++;
            right--;
            i+=2;
        }

        return res;
    }
}