class Solution {
    //using fast power algorithm
    public double myPow(double x, int n) {
        if(n<0){
            return 1/fastPow(x, (-1)*n);
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n){
        if(n == 0){
            return 1.0;
        }

        double half = fastPow(x, n/2);

        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}