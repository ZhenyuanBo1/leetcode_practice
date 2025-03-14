class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> trace = new ArrayList<>();

        int startSector = rounds[0];
        int endSector = -1;

        for(int i=1; i<rounds.length; i++){
            startSector = rounds[i-1];
            endSector = rounds[i];
            while(startSector!=endSector){
                trace.add(startSector);
                startSector = (startSector+1) <= n ? startSector+1 : (startSector+1)%n;
            }
        }

        trace.add(endSector);

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for(int i=0; i<trace.size(); i++){
            freq.put(trace.get(i), freq.getOrDefault(trace.get(i), 0) + 1);
        }

        int max = Collections.max(freq.values());

        List<Integer> res = new ArrayList<>();

        for(Integer key: freq.keySet()){
            if(freq.get(key) == max) res.add(key);
        }

        return res;


    }
}