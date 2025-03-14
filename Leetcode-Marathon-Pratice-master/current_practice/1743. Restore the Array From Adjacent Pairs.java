class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<adjacentPairs.length; i++){
            int[] pair = adjacentPairs[i];
            //pair[0] -> pair[1]
            if(map.containsKey(pair[0])){
                map.get(pair[0]).add(pair[1]);
            }else{
                Set<Integer> vals = new HashSet<>();
                vals.add(pair[1]);
                map.put(pair[0], vals);
            }
            //pair[1] -> pair[0]
            if(map.containsKey(pair[1])){
                map.get(pair[1]).add(pair[0]);
            }else{
                Set<Integer> vals = new HashSet<>();
                vals.add(pair[0]);
                map.put(pair[1], vals);
            }
        }

        int start = -1;
        for(Integer key: map.keySet()){
            if(map.get(key).size() == 1){
                start = key;
                break;
            }
        }

        int[] res = new int[adjacentPairs.length+1];

        dfs(res, 0, start, map,  new HashSet<>());

        return res;
    }
    private void dfs(int[] res, int index, int start, Map<Integer, Set<Integer>>map, Set<Integer> visited){
        if(index == res.length) return;

        res[index] = start;
        visited.add(start);

        Set<Integer> adjvals = map.get(start);

        for(Integer val: adjvals){
            if(!visited.contains(val)){
                dfs(res, index+1, val, map, visited);
            }
        }
    }
}