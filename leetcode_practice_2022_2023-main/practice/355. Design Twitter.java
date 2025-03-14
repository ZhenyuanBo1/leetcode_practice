class Twitter {
    class Pair{
        int timestamp;
        int tweetId;
        public Pair(int timestamp, int tweetId){
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }
    private HashMap<Integer, List<Integer>> followMap;
    private HashMap<Integer, PriorityQueue<Pair>> tweetMap;
    private int timestamp;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweetMap.containsKey(userId)){
            PriorityQueue<Pair> pq = tweetMap.get(userId);
            pq.add(new Pair(this.timestamp++, tweetId));
        }else{
            PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->p2.timestamp-p1.timestamp);
            pq.add(new Pair(this.timestamp++, tweetId));
            tweetMap.put(userId, pq);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> allnews = new PriorityQueue<>((p1, p2)->p2.timestamp-p1.timestamp);

        if(tweetMap.containsKey(userId)){
            PriorityQueue<Pair> pq = tweetMap.get(userId); // collection of tweets posted by user itself
            List<Pair> cache = new ArrayList<>();
            int size = pq.size();
            int i = 0;
            while(i<size){
                Pair p = pq.poll();
                allnews.add(p);
                cache.add(p);
                i++;
            }
            
            for(Pair p: cache){
                pq.add(p);
            }
        }

        if(followMap.containsKey(userId)){
            List<Integer> followees = followMap.get(userId);
            for(Integer id: followees){
                if(tweetMap.containsKey(id)){
                    PriorityQueue<Pair> pq = tweetMap.get(id); // collection of tweets posted by user itself
                    List<Pair> cache = new ArrayList<>();
                    int size = pq.size();
                    int i = 0;
                    while(i<size){
                        Pair p = pq.poll();
                        allnews.add(p);
                        cache.add(p);
                        i++;
                    }

                    for(Pair p: cache){
                        pq.add(p);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;

        while(count < 10 && !allnews.isEmpty()){
            Pair p = allnews.poll();
            res.add(p.tweetId);
            count++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            List<Integer> followees = followMap.get(followerId);
            if(followees.indexOf(followeeId) == -1) followMap.get(followerId).add(followeeId);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(followeeId);
            followMap.put(followerId, list);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            List<Integer> followees = followMap.get(followerId);
            if(followees.indexOf(followeeId) > -1){
                int indexToDelete = followees.indexOf(followeeId);
                followees.remove(indexToDelete);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */