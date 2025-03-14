class Solution {
    public int maxDistance(int[][] grid) {
        //using BFS
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[][]directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] pos = q.poll();
                for(int[] dir: directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visited[x][y] && grid[x][y] == 0){
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }

        return level <= 0 ? -1 : level;
    }
}