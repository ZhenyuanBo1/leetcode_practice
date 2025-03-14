class MRUQueue {
    List<Integer> list = new ArrayList<>();
    public MRUQueue(int n) {
        for(int i=1; i<=n; i++){
            list.add(i);
        }
    }
    
    public int fetch(int k) {
        int target = list.get(k-1);
        list.remove(k-1);
        list.add(target);
        return target;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */