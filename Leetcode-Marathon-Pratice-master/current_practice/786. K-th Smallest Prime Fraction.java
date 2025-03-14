class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        double left = 0, right = 1, mid = 0;

        //both left and right ends are open ended
        while(left < right){
            mid = left + (right-left)/2;
            int count = countSmallerOrEqual(mid, arr);
            if(count > k){
                right = mid;
            }else if(count < k){
                left = mid;
            }else {
                break;
            }
        }

        double max = 0;
        int[] ans = new int[2];

        /*
        1. once we find the mid, we need to find the one that is the cloest to mid
        2. XXXXX[X] mid ===> [x] is the closet one
        */
        for(int i=0; i<arr.length; i++){
            int j = arr.length-1;
            while(j>i && arr[i]*1.0/arr[j]<=mid){
                j--;
            }

            if(j+1<arr.length && arr[i]*1.0/arr[j+1]<=mid){
                int num = arr[i];
                int denom = arr[j+1];

                if(num*1.0/denom > max){
                    ans[0] = num;
                    ans[1] = denom;
                    max = num*1.0/denom;
                }
            }
        }

        return ans;

    }

    private int countSmallerOrEqual(double mid, int[] arr){
        int count = 0;
        int n = arr.length;
        //iterate through each number in arr as numerator
        //denominator has to be greater than or equal to numerator/mid
        //we are looking for the lower bound
        for(int i=0; i<arr.length; i++){
            int j=n-1;
            while(j>i && arr[i]*1.0/arr[j] <= mid){
                j--;
            }
            count += n-(j+1);
        }
        return count;
    }
}