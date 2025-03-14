class Solution {
    //BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};

        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                for(int k=0; k<4; k++){
                    int newr = cell[0] + rowOffset[k];
                    int newc = cell[1] + colOffset[k];
                    if(newr>=0 && newr<image.length && newc>=0 && newc<image[0].length && !visited[newr][newc] && image[newr][newc] == image[cell[0]][cell[1]]){
                        q.offer(new int[]{newr, newc});
                        visited[newr][newc] = true;
                    }
                }
            }
        }
        
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                if(visited[i][j]){
                    image[i][j] = color;
                }
            }
        }

        return image;
    }
}

//DFS
class Solution{
    private int[][] matrix;
    private boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.matrix = image;
        this.visited = new boolean[image.length][image[0].length];
        dfs(sr, sc, image[sr][sc]);

        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                if(visited[i][j]){
                    image[i][j] = color;
                }
            }
        }

        return image;
    }
    
    private void dfs(int r, int c, int val){
        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length || visited[r][c] || matrix[r][c] != val) return;

        visited[r][c] = true;

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            dfs(newr, newc, matrix[r][c]);
        }
    }
}