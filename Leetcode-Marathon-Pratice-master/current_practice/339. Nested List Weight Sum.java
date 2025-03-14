/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);

        int depth = 1, sum = 0;
        while(!q.isEmpty()){
            int size = q.size();
            //visit each depth
            for(int i=0; i<size; i++){
                NestedInteger item = q.remove();
                if(item.isInteger()){
                    sum += item.getInteger() * depth;
                }else{
                    q.add(item.getList());
                }
            }
            depth += 1;
        }

        return sum;
    }
}

//for level order traversing, we can use two approaches: 1). use Queue<List<...>> to store each level value in the queue
//2). calculate current size first and then iterate each item on that level using for(int i=0; i<currsize; i++); we need depth parameter for this approach