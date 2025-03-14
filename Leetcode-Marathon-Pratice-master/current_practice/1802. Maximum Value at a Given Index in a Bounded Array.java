class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long left = 1, right = maxSum;
        while(left < right){
            long mid = right - (right - left)/2;
            if(isOK(mid, index, n, maxSum)){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return (int)left;
    }

    private boolean isOK(long mid, long index, long n, long maxSum){

        long sum = 0;

        //left of mid (including mid)
        if(index < mid){
            sum += (mid - index + mid)*(index+1)/2;
        }else{
            sum += (1 + mid) * (mid)/2;
            long lowerIndex = index - mid;
            sum += lowerIndex+1;
        }

        // System.out.println(sum);

        //right of mid (excluding mid)
        if(n-(index+1) < mid){
            sum += (mid-(n-(index+1)) + mid) * (n-index)/2;
        }else{
            sum += (1+mid)*(mid)/2;
            sum += n-(index+mid);
        }
        sum -= mid;

        // System.out.println("mid: " + mid + " sum: " + sum);

        return sum <= maxSum;
    }
}