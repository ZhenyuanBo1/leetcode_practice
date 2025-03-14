class Vector2D {
    private Stack<Integer> st;
    public Vector2D(int[][] vec) {
       this.st = new Stack<>();

       for(int i=vec.length-1; i>=0; i--){
        for(int j=vec[i].length-1; j>=0; j--){
            this.st.push(vec[i][j]);
        }
       } 
    }
    
    public int next() {
        return this.st.pop();
    }
    
    public boolean hasNext() {
        if(this.st.isEmpty()) return false;
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */