class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();


        for(int i=0; i<mat.length; i++){
            int soldierCount = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    soldierCount += 1;
                }
            }
            if(map.containsKey(soldierCount)){
                map.get(soldierCount).add(i);
            }else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(soldierCount, indices);
            }
        }

        for(Integer key : map.keySet()){
            Collections.sort(map.get(key));
            for(Integer i : map.get(key)){
                list.add(i);
            }
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}