class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;

        //1. we first need to calculate the effort 2. minimize it using PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[row][col];

        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            //this returns the minimum effort to current time point
            int[] curr = pq.remove();
            if(curr[0] == row-1 && curr[1] == col-1) return curr[2];

            if (visited[curr[0]][curr[1]]) continue;

            visited[curr[0]][curr[1]] = true;

            for (int[] dir: dirs) {
                int newr = curr[0] + dir[0];
                int newc = curr[1] + dir[1];
                //check if it is outside of the boundary
                if(newr >=0 && newr < row && newc >=0 && newc < col && !visited[newr][newc]){
                    int effort = Math.max(curr[2], Math.abs(heights[curr[0]][curr[1]] - heights[newr][newc]));
                    pq.add(new int[]{newr, newc, effort});
                }
            }
        }

        return 0;
    }
}