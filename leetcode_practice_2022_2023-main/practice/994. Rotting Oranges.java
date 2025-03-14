class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[] rdirection = new int[]{0, -1, 0, 1};
        int[] cdirection = new int[]{1, 0, -1, 0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean hasRotten = false;
        int freshOrange = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    int[] rotten = new int[2];
                    rotten[0] = i;
                    rotten[1] = j;
                    q.offer(rotten);
                    visited[i][j] = true;
                    hasRotten = true;
                }else if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }

        int min = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int j=0; j<4; j++){
                    int newr = curr[0] + rdirection[j];
                    int newc =  curr[1] + cdirection[j];
                    if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && !visited[newr][newc] && grid[newr][newc] == 1){
                        q.offer(new int[]{newr, newc});
                        freshOrange--;
                        visited[newr][newc] = true;
                    }
                }
            }
            min++;
        }

        if(!hasRotten && freshOrange == 0) return 0;

        return freshOrange == 0 ? min : -1;
    }
}