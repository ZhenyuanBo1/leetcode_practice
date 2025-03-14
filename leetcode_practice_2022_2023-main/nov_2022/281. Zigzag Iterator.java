public class ZigzagIterator {
    private List<Integer> list;
    private int p1;
    private int p2;
    private int pointer;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.list = new ArrayList<>();
        this.p1 = 0;
        this.p2 = 0;
        this.pointer = -1;
        helper(v1, v2);
    }

    public int next() {
        return this.list.get(++pointer);
    }

    public boolean hasNext() {
        if(pointer + 1 < this.list.size()) return true;
        return false;
        
    }

    private void helper(List<Integer> v1, List<Integer> v2){
        while(p1<v1.size() || p2<v2.size()){
            if(p1<v1.size()){
                this.list.add(v1.get(p1++));
            }
            if(p2<v2.size()){
                this.list.add(v2.get(p2++));
            }
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */