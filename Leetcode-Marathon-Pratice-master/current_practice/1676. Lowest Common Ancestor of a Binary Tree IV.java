class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));

        List<List<Integer>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            List<Integer> path = q.remove();

            // check if the node is already the last node
            int lastNode = path.get(path.size() - 1);

            if (lastNode == graph.length - 1) {
                ans.add(path);
            } else {
                int[] neighbors = graph[lastNode];
                for (int neighbor : neighbors) {
                    // for each new path, we create a new arraylist
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    q.add(newPath);
                }
            }
        }

        return ans;
    }
}