class Solution {
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<heights.length; i++){
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, heights[0].length-1});
        }

        for(int j=0; j<heights[0].length; j++){
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{heights.length-1, j});
        }

        boolean[][] pacificReachable = bfs(pacificQueue, heights);
        boolean[][] atlanticReachable = bfs(atlanticQueue, heights);

        for(int i=0; i<this.rows; i++){
            for(int j=0; j<this.cols; j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;


    }

    private boolean[][] bfs(Queue<int[]> queue, int[][] heights){
        boolean[][] reachable = new boolean[this.rows][this.cols];

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{-1, 0, 1, 0};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            reachable[cell[0]][cell[1]] = true;
            for(int i=0; i<4; i++){
                int r = cell[0] + rowOffset[i];
                int c = cell[1] + colOffset[i];

                if(r<0 || r>=this.rows || c<0 || c>=this.cols || reachable[r][c]) continue;

                if(heights[r][c] >= heights[cell[0]][cell[1]]){
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return reachable;
    }

}