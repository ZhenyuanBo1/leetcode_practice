class TwoSum {

    private List<Integer> list;
    private Map<Integer, List<Integer>> map;
    private int index;

    public TwoSum() {
       this.list = new ArrayList<>();
        map = new HashMap<>();
        index = 0;
    }

    public void add(int number) {
        this.list.add(number);
        if(map.containsKey(number)){
            map.get(number).add(index++);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(index++);
            map.put(number, list);
        }
    }

    public boolean find(int value) {
        for(int i=0; i<list.size(); i++){
            int targetVal = value - list.get(i);
            if(map.containsKey(targetVal)){
                if(targetVal == list.get(i) && map.get(targetVal).size() > 1) return true;
                else if(targetVal != list.get(i)) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */