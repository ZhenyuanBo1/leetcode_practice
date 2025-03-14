class MinStack {
    TreeMap<Integer, Integer> tmap;
    private Stack<Integer> st;

    public MinStack() {
        this.st = new Stack<>();
        this.tmap = new TreeMap<>();
    }
    
    public void push(int val) {
        st.push(val);
        tmap.put(val, tmap.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int deletedVal = st.peek();
        if(tmap.get(deletedVal) == 1){
            tmap.remove(deletedVal);
        }else{
            tmap.put(deletedVal, tmap.get(deletedVal)-1);
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return (int)tmap.keySet().toArray()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 /*
we can also create a minStack that keeps track of current minimum value and push that to the top of the stack.
when getting the minimum value, we just pop the one on the top, which is o(1)
*/