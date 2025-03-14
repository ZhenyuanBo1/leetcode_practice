class Solution {
    private int M = 1000000000 + 7;
    public int countGoodNumbers(long n) {
        long even = 0, odd = 0;

        if(n%2 != 0){
            even = n/2 + 1;
        }else{
            even = n/2;
        }

        odd = n-even;

        int res = (int)(calculatePow(5, even)*calculatePow(4, odd)%M);

        return res;
    }
    private long calculatePow(long num, long n){
        if(n == 0) return 1;

        long half = calculatePow(num, n/2);

        if(n % 2 == 0){
            return (half*half)%M;
        }else{
            return half*half%M*num%M;
        }
    }
}