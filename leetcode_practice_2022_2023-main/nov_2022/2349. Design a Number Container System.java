class NumberContainers {
    private HashMap<Integer, PriorityQueue<Integer>> map;
    private HashMap<Integer, Integer> map1;
    public NumberContainers() {
        this.map = new HashMap<>();
        this.map1 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(this.map1.containsKey(index)){
            int val = this.map1.get(index);
            if(val == number) return; //if the value that needs to be replaced is the same as number, then skip
            if(this.map.containsKey(val)){
                PriorityQueue<Integer> pq = this.map.get(val);
                pq.remove(index);
            }
        }
        this.map1.put(index, number);
        if(this.map.containsKey(number)){
            PriorityQueue<Integer> pq1 = this.map.get(number);
            pq1.add(index);
        }else{
            PriorityQueue<Integer> pq2 = new PriorityQueue<>((n1, n2)->n1-n2);
            pq2.add(index);
            this.map.put(number, pq2);
        }
    }
    
    public int find(int number) {
        if(this.map.containsKey(number)){
            if(this.map.get(number).size() > 0) return this.map.get(number).peek();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */