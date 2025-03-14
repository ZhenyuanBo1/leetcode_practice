class Solution {
    class Pair{
        String id;
        long view;
        public Pair(String id, long view){
            this.id = id;
            this.view = view;
        }
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Long> map1 = new HashMap<>();
        HashMap<String, PriorityQueue<Pair>> map2 = new HashMap<>();

        for(int i=0; i<creators.length; i++){
            String creator = creators[i];
            if(map1.containsKey(creator)){
                map1.put(creator, map1.get(creator) + (long)views[i]);
            }else{
                map1.put(creator, (long)views[i]);
            }

            Pair p = new Pair(ids[i], (long)views[i]);
            if(map2.containsKey(creator)){
                map2.get(creator).add(p);
            }else{
                PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
                    if(p1.view == p2.view){
                        return p1.id.compareTo(p2.id);
                    }else{
                        return Long.compare(p2.view, p1.view);
                    }
                });
                pq.add(p);
                map2.put(creator, pq);
            }
        }

        long max = Long.MIN_VALUE;

        for(String s: map1.keySet()){
            max = Math.max(max, map1.get(s));
        }        

        List<List<String>> res = new ArrayList<>();

        for(String s: map1.keySet()){
            if(map1.get(s) == max){
                List<String> ans = new ArrayList<>();
                ans.add(s);
                ans.add(map2.get(s).peek().id);
                res.add(ans);
            }
        }

        return res;



    }
}