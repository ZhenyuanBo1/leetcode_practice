class RecentCounter {
    Queue<Integer> q;
    
    public RecentCounter() {
        this.q = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.q.add(t);        
        while(this.q.peek() < t-3000){
            this.q.remove();
        }
        
        return this.q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */