class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
       Map<Integer, List<Integer>> rowColMap = new HashMap<>();
       Map<Integer, List<Integer>> colRowMap = new HashMap<>();

       //build rowColMap
       for(int i=0; i<mat1.length; i++){
           for(int j=0; j<mat1[0].length; j++){
               if(mat1[i][j]!=0){
                   if(!rowColMap.containsKey(i)){
                       List<Integer> colIndexList = new ArrayList<>();
                       colIndexList.add(j);
                       rowColMap.put(i, colIndexList);
                   }else{
                       rowColMap.get(i).add(j);
                   }
               }
           }
       }

       //build colRowMap
       for(int i=0; i<mat2[0].length; i++){
           for(int j=0; j<mat2.length; j++){
               if(mat2[j][i]!=0){
                   if(!colRowMap.containsKey(i)){
                       List<Integer> rowIndexList = new ArrayList<>();
                       rowIndexList.add(j);
                       colRowMap.put(i, rowIndexList);
                   }else{
                       colRowMap.get(i).add(j);
                   }
               }
           }
       }

       int[][] res = new int[mat1.length][mat2[0].length];

       for(int i=0; i<res.length; i++){
           for(int j=0; j<res[0].length; j++){
               if(rowColMap.containsKey(i) && colRowMap.containsKey(j)){
                   int total = 0;
                   for(Integer colIndex: rowColMap.get(i)){
                       if(colRowMap.get(j).contains(colIndex)){
                           total += mat1[i][colIndex] * mat2[colIndex][j];
                       }
                   }
                   res[i][j] = total;
               }
           }
       }

       return res;


    }
}