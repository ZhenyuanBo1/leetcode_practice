class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;

        //we only need to check prime from 2 to the sqrt(n)
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i=2; i<=Math.sqrt(n); i++){
            if(!isPrime[i]) continue;
            for(int j=2; i*j<n; j++){
                isPrime[i*j] = false;
            }
        }

        int count = 1;

        for(int i=3; i<n; i++){
            if(isPrime[i]) count+=1;
        }

        return count;
    }
}