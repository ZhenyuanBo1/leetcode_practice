class MyHashMap {
    private List<Integer> indices;
    private List<Integer> values;
    public MyHashMap() {
        indices = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void put(int key, int value) {
        if(indices.contains(key)){
            int index = indices.indexOf(key);
            values.set(index, value);
        }else{
            indices.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        if(indices.contains(key)){
            int index = indices.indexOf(key);
            return values.get(index);
        }
        return -1;
    }

    public void remove(int key) {
        int index = indices.indexOf(key);
        if(index>-1){
            values.remove(index);
            indices.remove(index);
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