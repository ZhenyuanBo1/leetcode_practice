class Solution {
    public boolean judgeSquareSum(int c) {
        for(long i=0; i*i<=c; i++){
            long aSquare = i*i;
            long target = c - aSquare;

            long left = 0, right = c;
            boolean flag = false;

            while(left < right){
                long mid = left + (right - left)/2;
                if(mid * mid > target){
                    right = mid-1;
                }else if(mid * mid < target){
                    left = mid + 1;
                }else{
                    flag = true;
                    break;
                }
            }

            if(flag) return true;
            if(left == right && left * left == target) return true;
        }
        return false;
    }
}