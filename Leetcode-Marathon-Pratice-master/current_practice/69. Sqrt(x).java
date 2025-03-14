class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;

        while(left < right){
            long mid = right - (right - left)/2;
            if(mid * mid <= x){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        if(left == right && left * left <= x) return (int)left;

        return 0;
    }
}