class Solution {
    class Pair{
        char c; 
        int freq;
        public Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        if(a == 0 && b == 0 && c == 0) return "";
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);
        if(a>0) pq.offer(new Pair('a', a));
        if(b>0) pq.offer(new Pair('b', b));
        if(c>0) pq.offer(new Pair('c', c));

        String s = "";

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int freq = p.freq;
            
            if(s.equals("") || s.charAt(s.length()-1) != p.c){
                int count = Math.min(2, freq);
                for(int i=0; i<count; i++){
                    s += p.c;
                }
                int newFreq = freq - count;
                if(newFreq > 0) pq.offer(new Pair(p.c, newFreq));
            }else{
                if(pq.isEmpty()) break;
                Pair p1 = pq.poll();
                s+=p1.c;
                int newFreq = p1.freq-1;
                if(newFreq > 0) pq.offer(new Pair(p1.c, newFreq));
                pq.offer(new Pair(p.c, freq));
            }
        }
        return s;
    }
}