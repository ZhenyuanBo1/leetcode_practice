class Solution {
    //neighbor list
    private Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        //build neighbor list
        for(int i=0; i<times.length; i++){
            int[] time = times[i];
            int src = time[0];
            int des = time[1];
            int cost = time[2];

            if(map.containsKey(src)){
                map.get(src).add(new Pair(cost, des));
            }else{
                List<Pair<Integer, Integer>> list = new ArrayList<>();
                list.add(new Pair(cost, des));
                map.put(src, list);
            }
        }

        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        this.BFS(signalReceivedAt, k);

        int ans = Integer.MIN_VALUE;

        for(int i=1; i<signalReceivedAt.length; i++){
            ans = Math.max(ans, signalReceivedAt[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private void BFS(int[] signalReceivedAt, int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        signalReceivedAt[src] = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Integer node = q.remove();
                if(!map.containsKey(node)) continue;
                for(Pair<Integer, Integer> pair: map.get(node)){
                    int timeTravelled = pair.getKey();
                    int nei = pair.getValue();
                    int arrivalTime = signalReceivedAt[node] + timeTravelled;
                    //only add nodes that the travelledTime is less than the current time
                    if(signalReceivedAt[nei] > arrivalTime){
                        signalReceivedAt[nei] = arrivalTime;
                        q.add(nei);
                    }
                }
            }
        }
    }
}