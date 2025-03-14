class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] trip: trips){
            int s = trip[1];
            int e = trip[2];
            map.put(s, map.getOrDefault(s, 0)+trip[0]);
            map.put(e, map.getOrDefault(e, 0)-trip[0]);
        }

        int curr = 0;

        for(Integer key: map.keySet()){
            curr += map.get(key);
            if(curr > capacity) return false;
        }

        return true;
    }
}