class CustomStack {
    private Stack<Integer> st;
    private Stack<Integer> st1;
    private int maxSize;
    public CustomStack(int maxSize) {
        this.st = new Stack<>();
        this.st1 = new Stack<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(this.st.size() < this.maxSize){
            st.push(x);
        }
    }
    
    public int pop() {
        if(this.st.isEmpty()) return -1;
        return this.st.pop();
    }
    
    public void increment(int k, int val) {
        //transfer to st1
        while(!this.st.isEmpty()){
            this.st1.push(this.st.pop());
        }

        int i=0;

        while(i<k && !this.st1.isEmpty()){
            int currVal = this.st1.pop();
            int newVal = currVal + val;
            this.st.push(newVal);
            i++;
        }
        
        while(!this.st1.isEmpty()){
            this.st.push(this.st1.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */