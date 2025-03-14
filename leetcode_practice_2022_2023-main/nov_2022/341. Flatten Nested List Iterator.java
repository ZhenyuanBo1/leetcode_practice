/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int pointer;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.pointer = -1;
        helper(nestedList);
    }

    @Override
    public Integer next() {
        int nextVal = this.list.get(++pointer);
        return nextVal;
    }

    @Override
    public boolean hasNext() {
        if(pointer+1<list.size()) return true;
        return false;
    }

    private void helper(List<NestedInteger> nestedList){
        for(NestedInteger item: nestedList){
            if(item.isInteger()){
                this.list.add(item.getInteger());
            }else{
                List<NestedInteger> subList = item.getList();
                helper(subList);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */