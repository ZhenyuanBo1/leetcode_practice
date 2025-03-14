class Solution {
    public int diagonalSum(int[][] mat) {
        int primarySum = 0;
        int secondarySum = 0;
        int j=0;

        for(int i=0; i<mat.length; i++){
            primarySum += mat[i][j];
            j+=1;
        }

        j=mat[0].length-1;

        for(int i=0; i<mat.length; i++){
            if(i!=j){
                secondarySum += mat[i][j];
            }
            j--;
        }

        return primarySum + secondarySum;

    }
}