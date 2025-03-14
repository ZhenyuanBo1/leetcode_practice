class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        Map<Integer, String> rowMap = new HashMap<>();
        Map<Integer, String> colMap = new HashMap<>();

        for(int i=0; i<grid.length; i++){
            String row = "";
            for(int j=0; j<grid[i].length; j++){
                row += grid[i][j] + ",";
            }
            row = row.substring(0, row.length()-1);
            rowMap.put(i, row);
        }

        for(int i=0; i<grid[0].length; i++){
            String col = "";
            for(int j=0; j<grid.length; j++){
                col += grid[j][i] + ",";
            }
            col = col.substring(0, col.length()-1);
            colMap.put(i, col);
        }


        for(Integer r: rowMap.keySet()){
            for(Integer c: colMap.keySet()){
                if(rowMap.get(r).equals(colMap.get(c))) count++;
            }
        }

        return count;
    }
}