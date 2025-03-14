class Solution {
    public double myPow(double x, int n) {
        boolean isPositive = n > 0;

        double val = fastPow(x, Math.abs(n));

        if(!isPositive) return 1.0/val;

        return val;
    }
    
    private double fastPow(double x, int n){
        if(n == 0) return 1.0;

        double half = fastPow(x, n/2);

        if(n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}