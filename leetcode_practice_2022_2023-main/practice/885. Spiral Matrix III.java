class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int count = 1;
        List<int[]> list = new ArrayList<>();
        int step = 0;
        int r = rStart;
        int c = cStart;
        list.add(new int[]{r, c});
        int[] rowOffset = new int[]{0, 1, 0, -1};
        int [] colOffset = new int[]{1, 0, -1, 0};
        int j = 0;

        while(count < rows*cols){
            for(int i=0; i<step/2+1; i++){
                r += rowOffset[j];
                c += colOffset[j];
                if(r>=0 && r<rows && c>=0 && c<cols){
                    int[] coordinate = new int[]{r, c};
                    list.add(coordinate);
                    count++;
                }
            }
            step++;
            j = (j+1) % 4;
        }

        int[][] res = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        return res;
    }
}