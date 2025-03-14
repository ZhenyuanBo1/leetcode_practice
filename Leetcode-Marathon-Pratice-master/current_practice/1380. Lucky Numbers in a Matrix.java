class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMins = new int[matrix.length];
        int[] colMaxs = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            int max = Integer.MAX_VALUE;
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] < max){
                    rowMins[i] = matrix[i][j];
                    max = matrix[i][j];
                }
            }
        }

        for(int j=0; j<matrix[0].length; j++){
            int min = Integer.MIN_VALUE;
            for(int i=0; i<matrix.length; i++){
                if(matrix[i][j] > min){
                    colMaxs[j] = matrix[i][j];
                    min = matrix[i][j];
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<rowMins.length; i++){
            for(int j=0; j<colMaxs.length; j++){
                if(rowMins[i]==colMaxs[j]){
                    ans.add(rowMins[i]);
                }
            }
        }

        return ans;


    }
}