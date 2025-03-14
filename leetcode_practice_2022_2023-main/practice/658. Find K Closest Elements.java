class Solution {
    class Pair{
        int diff;
        int val;
        public Pair(int diff, int val){
            this.diff = diff;
            this.val = val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.diff == p2.diff){
                return p1.val - p2.val;
            }else{
                return p1.diff - p2.diff;
            }
        });

        for(int i: arr){
            Pair p = new Pair(Math.abs(i-x), i);
            pq.offer(p);
        }

        List<Integer> res = new ArrayList<>();

        while(k>0){
            Pair p = pq.poll();
            res.add(p.val);
            k--;
        }

        Collections.sort(res);

        return res;
    }
}