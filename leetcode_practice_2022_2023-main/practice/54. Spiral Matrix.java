class Solution {
    //frequency: 8
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int count = 1;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        list.add(matrix[0][0]);
        visited[0][0] = true;

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};
        int j = 0;

        int r = 0, c = 0;

        while(count < matrix.length * matrix[0].length){
            int limit = j % 2 == 0 ? matrix[0].length : matrix.length;
            for(int i=0; i<limit-1; i++){
                if(visited[r+rowOffset[j]][c+colOffset[j]]) break;
                r+=rowOffset[j];
                c+=colOffset[j];
                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length){
                    list.add(matrix[r][c]);
                    count++;
                    visited[r][c] = true;
                }else{
                    break;
                }
            }
            j = (j+1) % 4;
        }

        return list;
    }
}