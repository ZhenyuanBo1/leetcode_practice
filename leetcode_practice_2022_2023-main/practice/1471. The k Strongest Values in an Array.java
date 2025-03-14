class Solution {
    class Pair{
        int strength;
        int val;
        public Pair(int strength, int val){
            this.strength = strength;
            this.val = val;
        }
    }
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;

        Arrays.sort(arr);

        int median = arr[(n-1)/2];

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.strength == p2.strength) return p2.val - p1.val;
            else return p2.strength - p1.strength;
        });

        for(int i = 0; i<arr.length; i++){
            Pair p = new Pair(Math.abs(arr[i] - median), arr[i]);
            pq.offer(p);
        }

        int[] ans = new int[k];

        int i=0;

        while(k>0){
            Pair p = pq.poll();
            ans[i++] = p.val;
            k--;
        }

        return ans;
    }
}