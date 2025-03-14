// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int pointer;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.list = new ArrayList<>();
        this.pointer = -1;
        for(Integer i: iterator){
            if(iterator.hasNext()){
                this.list.add(iterator.next());
            }
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        int nextVal = this.list.get(pointer+1);
        return nextVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int nextVal = this.list.get(++pointer);
        return nextVal;
	}
	
	@Override
	public boolean hasNext() {
	    if(pointer + 1 < this.list.size()) return true;
        return false
	}
}