class Solution {
    class Pair{
        int index;
        int popularity;
        public Pair(int index, int popularity){
            this.index = index;
            this.popularity = popularity;
        }
    }
    public String[] sortFeatures(String[] features, String[] responses) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.popularity == p2.popularity){
                return p1.index - p2.index;
            }else{
                return p2.popularity - p1.popularity;
            }
        });
        
        Set<String> feature_set = new HashSet<>();

        for(String feature: features){
            feature_set.add(feature);
        }
        
        //using freq map!
        Map<String, Integer> freq = new HashMap<>();

        for(String response: responses){
            String[] arr = response.split("\\s");
            Set<String> seen = new HashSet<>();
            for(String s: arr){
                if(!seen.contains(s) && feature_set.contains(s)){
                    seen.add(s);
                    freq.put(s, freq.getOrDefault(s, 0) + 1);
                }
            }
        }
        
        for(int i=0; i<features.length; i++){
            if(!freq.containsKey(features[i])){
                Pair p = new Pair(i, 0);
                pq.offer(p);
            }else{
                Pair p = new Pair(i, freq.get(features[i]));
                pq.offer(p);
            }
        };

        String[] res = new String[features.length];

        int i = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            res[i++] = features[p.index];
        }

        return res;

    }
}