class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int j = q.remove();
                if(visited[j]) continue;
                visited[j] = true;
                List<Integer> keys = rooms.get(j);
                q.addAll(keys);
            }
        }

        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }

        return true;

    }
}