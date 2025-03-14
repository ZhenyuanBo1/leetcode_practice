class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Map<Integer, List<int[]>> map = new TreeMap<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int distance = Math.abs(i-rCenter) + Math.abs(j-cCenter);
                int[] cell = new int[2];
                cell[0] = i;
                cell[1] = j;
                if(map.containsKey(distance)){
                    map.get(distance).add(cell);
                }else{
                    List<int[]> list = new ArrayList<>();
                    list.add(cell);
                    map.put(distance, list);
                }
            }
        }


        int count=0;

        for(Integer key: map.keySet()){
            count += map.get(key).size();
        }

        int[][] ans = new int[count][2];

        int rIndex = 0;

        for(Integer key: map.keySet()){
            for(int[] item: map.get(key)){
                ans[rIndex][0] = item[0];
                ans[rIndex][1] = item[1];
                rIndex += 1;
            }
        }

        return ans;
    }
}