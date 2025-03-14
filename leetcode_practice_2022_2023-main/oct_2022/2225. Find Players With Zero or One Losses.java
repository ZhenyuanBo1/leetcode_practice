class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<matches.length; i++){
            int w = matches[i][0];
            int l = matches[i][1];
            if(!map.containsKey(w)){
                map.put(w, 0); // lost 0 match so far for this w
            }
            if(!map.containsKey(l)){
                map.put(l, 1);
            }else{
                map.put(l, map.get(l)+1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> zeroLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        for(Integer i: map.keySet()){
            if(map.get(i) == 0) zeroLost.add(i);
            else if(map.get(i) == 1) oneLost.add(i);
        }

        Collections.sort(zeroLost);
        Collections.sort(oneLost);

        res.add(zeroLost);
        res.add(oneLost);

        return res;

    }
}