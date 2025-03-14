class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        for(int i=0; i+2<grid.length; i++){
            for(int j=0; j+2<grid[0].length; j++){
                if(isMagicSquare(grid, i, j)) count+=1;
            }
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid, int rStart, int cStart){

        Set<Integer> sumSet = new HashSet<>();

        Set<Integer> distinctSet = new HashSet<>();


        //check rowSum
        for(int i=rStart; i<rStart+3; i++){
            int rowSum = 0;
            for(int j=cStart; j<cStart+3; j++){
                rowSum += grid[i][j];
                distinctSet.add(grid[i][j]);
            }
            sumSet.add(rowSum);
        }

        if(distinctSet.size() != 9) return false;

        for(Integer val: distinctSet){
            if(val > 9 || val < 1) return false;
        }

        //check colSum
        for(int i=cStart; i<cStart+3; i++){
            int colSum = 0;
            for(int j=rStart; j<rStart+3; j++){
                colSum += grid[j][i];
            }
            sumSet.add(colSum);
        }

        //check diagonalSum
        int diagSum1 = grid[rStart][cStart] + grid[rStart+1][cStart+1] + grid[rStart+2][cStart+2];
        int diagSum2 = grid[rStart][cStart+2] + grid[rStart+1][cStart+1] + grid[rStart+2][cStart];

        sumSet.add(diagSum1);
        sumSet.add(diagSum2);

        if(sumSet.size() == 1) return true;

        return false;


    }
}