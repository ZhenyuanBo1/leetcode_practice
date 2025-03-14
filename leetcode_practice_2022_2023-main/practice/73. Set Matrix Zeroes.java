class Solution {
    List<List<Integer>> allPos = new ArrayList<>();
    public void setZeroes(int[][] matrix) {
       for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j] == 0){
                List<Integer> currPos = new ArrayList<>(Arrays.asList(i, j));
                allPos.add(currPos);
            }
        }
       }
        
       if(allPos.size() > 0){
        for(List<Integer> list: allPos){
            this.setZeroesHelper(matrix, list.get(0), list.get(1));
        }
       }
    }
    private void setZeroesHelper(int[][] matrix, int r, int c){
        for(int i=0; i<matrix[0].length; i++){
            matrix[r][i] = 0;
        }
        for(int j=0; j<matrix.length; j++){
            matrix[j][c] = 0;
        }
    }
}