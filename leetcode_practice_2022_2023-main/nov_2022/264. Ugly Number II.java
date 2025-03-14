class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] arr = new int[1690];
        Set<Long> seen = new HashSet<>();
        pq.add(1L);
        seen.add(1L);

        int[] primes = new int[]{2, 3, 5};
        long currUgly, newUgly;
        for(int i=0; i<1690; i++){
            currUgly = pq.poll();
            arr[i] = (int)currUgly;
            for(int p: primes){
                newUgly = currUgly * p;
                if(!seen.contains(newUgly)){
                    seen.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }

        return arr[n-1];
    }
}