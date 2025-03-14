class Solution {
    class Pair{
        int index;
        int diff;
        public Pair(int index, int diff){
            this.index = index;
            this.diff = diff;
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((n1, n2) -> n1.diff - n2.diff);

        for(int i=0; i<costs.length; i++){
            int[] cost = costs[i];
            int currDiff = cost[1] - cost[0];
            pq.offer(new Pair(i, currDiff));
        }

        int count = costs.length/2;

        int cost = 0;

        for(int i=0; i<count; i++){
            Pair p = pq.poll();
            cost += costs[p.index][1];
        }

        for(int i=0; i<count; i++){
            Pair p = pq.poll();
            cost += costs[p.index][0];
        }

        return cost;
    }
}