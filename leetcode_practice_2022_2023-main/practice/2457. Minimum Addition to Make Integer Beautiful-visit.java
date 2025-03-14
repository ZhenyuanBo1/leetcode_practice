class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        /*
        Key idea: If the current number's digit sum is greater than target, 
        then it's less likely that any number greater than the current one 
        until we reach the next ten's multiple will be higher than the target.
        */
        long nCopy = n;
        int digitSum = getDigitSum(n);
        if(digitSum <= target) return 0;

        int round = 1;

        long beautyNumber = 0;

        while(digitSum > target){
            n /= 10;
            beautyNumber = (long)((n+1) * Math.pow(10, round));
            digitSum = getDigitSum(beautyNumber);
            round++;
        }

        return beautyNumber - nCopy;
        
    }
    private int getDigitSum(long n){
        long sum = 0;

        while(n != 0){
            long remainder = n % 10;
            sum += remainder;
            n /= 10;
        }

        return (int)sum;
    }
}