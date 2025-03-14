class Solution {
    private int[] res;
    private int pos;
    private boolean hasLoop;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        pos = res.length-1;

        Queue<Integer>[] graph = new Queue[numCourses]; //this prepares neighbour list for each course

        for(int i=0; i<res.length; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] prerequisite: prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i=0; i<res.length; i++){
            dfs(graph, i, visited, path);
        }

        return hasLoop ? new int[0] : res;
    }
    private void dfs(Queue<Integer>[] graph, int next, boolean[] visited, boolean[] path){
        //travel all the way to the bottom and if it has no neighbors, then put it in the res
        if(path[next]){
            hasLoop = true;
            return;
        }else if(hasLoop || visited[next]){
            return;
        }

        visited[next] = true;
        path[next] = true;

        Queue<Integer> q = graph[next];

        while(!q.isEmpty()){
            int target = q.poll();
            dfs(graph, target, visited, path);
        }

        path[next] = false;
        res[pos--] = next;
    }
}