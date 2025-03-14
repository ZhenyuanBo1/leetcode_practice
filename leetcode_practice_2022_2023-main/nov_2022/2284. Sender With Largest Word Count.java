class Solution {
    class Pair{
        int freq;
        String sender;
        public Pair(int freq, String sender){
            this.freq = freq;
            this.sender = sender;
        }
    }
    public String largestWordCount(String[] messages, String[] senders) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->{
            if(p1.freq == p2.freq){
                return p2.sender.compareTo(p1.sender);
            }else{
                return Integer.compare(p2.freq, p1.freq);
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<senders.length; i++){
            String sender = senders[i];
            int count = messages[i].split(" ").length;
            map.put(sender, map.getOrDefault(sender, 0) + count);
        }

        for(String s: map.keySet()){
            int c = map.get(s);
            Pair p = new Pair(c, s);
            pq.add(p);
        }

        return pq.peek().sender;

    }
}