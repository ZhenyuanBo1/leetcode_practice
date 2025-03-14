class Solution {
    class Pair{
        int count;
        String word;
        public Pair(int count, String word){
            this.count = count;
            this.word = word;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.count == p2.count){
                return p1.word.compareTo(p2.word);
            }else{
                return Integer.compare(p2.count, p1.count);
            }
        });

        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for(String key: map.keySet()){
            int freq = map.get(key);
            Pair p = new Pair(freq, key);
            pq.add(p);
        }
        
        List<String> res = new ArrayList<>();
        
        int count = 0;
        while(count < k){
            Pair c = pq.poll();
            res.add(c.word);
            count++;
        }

        return res;
    }
}