class MyHashMap {
    private List<Integer> list1;
    private List<Integer> list2;
    public MyHashMap() {
        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(this.list1.indexOf(key) > -1){
            // System.out.println("key: " + key + " value: " + value);
            // System.out.println(this.list2);
            int index = this.list1.indexOf(key);
            this.list2.set(index, value);
            System.out.println(this.list2);
        }else{
            this.list1.add(key);
            this.list2.add(value);
        }
    }
    
    public int get(int key) {
        // System.out.println(this.list1);
        int index = this.list1.indexOf(key);
        if(index == -1) return -1;
        return this.list2.get(index);
    }
    
    public void remove(int key) {
        // System.out.println("remove key: " + key);
        int index = this.list1.indexOf(key);
        if(index != -1){
            this.list1.remove(index);
            this.list2.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */