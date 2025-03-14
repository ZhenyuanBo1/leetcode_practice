class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0)+1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(Integer key: map.keySet()){
            if(map.get(key) == mat.length) pq.offer(key);
        }

        return pq.isEmpty() ? -1 : pq.poll();
    }
}