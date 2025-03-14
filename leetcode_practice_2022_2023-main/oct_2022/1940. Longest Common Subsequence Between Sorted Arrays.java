class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays[i].length; j++){
                map.put(arrays[i][j], map.getOrDefault(arrays[i][j], 0) + 1);
            }
        }

        int size = arrays.length;

        List<Integer> res = new ArrayList<>();

        for(Integer key: map.keySet()){
            if(map.get(key) == size) res.add(key);
        }

        Collections.sort(res);

        return res;
    }
}