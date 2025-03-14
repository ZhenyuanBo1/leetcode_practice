class RandomizedSet {
    private List<Integer> list;
    public RandomizedSet() {
        this.list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(this.list.indexOf(val)>-1){
            return false;
        }
        this.list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(this.list.indexOf(val) > -1){
            int index = this.list.indexOf(val);
            this.list.remove(index);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = this.list.size();
        int min = 0;
        int randomIndex = (int)(Math.random()*size) + min;
        return this.list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */