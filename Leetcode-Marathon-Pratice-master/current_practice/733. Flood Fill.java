class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int r = image.length, c = image[0].length;
        int[][] newImage = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                newImage[i][j] = image[i][j];
            }
        }

        newImage[sr][sc] = newColor;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        boolean[][] visited = new boolean[r][c];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] point = q.remove();

            if(visited[point[0]][point[1]]) continue;

            visited[point[0]][point[1]] = true;

            for(int[] dir: dirs){
                int newr = point[0] + dir[0];
                int newc = point[1] + dir[1];

                if(newr >= 0 && newr < r && newc >=0 && newc < c && image[newr][newc] == image[point[0]][point[1]] && !visited[newr][newc]){
                    newImage[newr][newc] = newColor;
                    q.add(new int[]{newr, newc});
                }
            }
        }

        return newImage;

    }
}