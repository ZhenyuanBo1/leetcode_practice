class Solution {
    private int[][]adjMatrix;
    private HashMap<Pair<Integer, Integer>, Long> memo;
    //memorization and DFS
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.adjMatrix = new int[n][n];
        this.memo = new HashMap<>();

        for(int i=0; i<flights.length; i++){
            int[] flight = flights[i];
            int s = flight[0], d = flight[1], c = flight[2];
            this.adjMatrix[s][d] = c;
        }

        Long ans = dfs(src, dst, k, n);

        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }

    private long dfs(int src, int dst, int k, int n){
        //base case
        if(src == dst) return 0;
        if(k<0) return Long.MAX_VALUE;


        Pair<Integer, Integer> p = new Pair<>(src, k);

        if(memo.containsKey(p)) return memo.get(p);

        long ans = Long.MAX_VALUE;

        for(int i=0; i<n; i++){
            int price = adjMatrix[src][dst];
            if(price > 0) ans = Math.min(ans, dfs(src, dst, k-1, n) + adjMatrix[src][dst]);
        }

        memo.put(p, ans);
        return ans;
    }
}