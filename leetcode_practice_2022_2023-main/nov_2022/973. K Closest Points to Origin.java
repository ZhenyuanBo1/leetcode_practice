class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int distance = (point[0]) * (point[0]) + point[1] * point[1];
            if(map.containsKey(distance)){
                List<Integer> indices = map.get(distance);
                indices.add(i);
            }else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(distance, indices);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)->n1-n2);

        for(Integer key: map.keySet()){
            pq.add(key);
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;

        while(count < k){
            List<Integer> indices = map.get(pq.poll());
            for(Integer i: indices){
                res.add(i);
            }
            count+= indices.size();
        }

        int[][] ans = new int[k][2];

        for(int i=0; i<res.size(); i++){
            int index = res.get(i);
            int[] point = points[index];
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }

        return ans;
    }
}