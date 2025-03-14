class BrowserHistory {
    private Stack<String> st1;
    private Stack<String> st2;
    private String homepage;

    public BrowserHistory(String homepage) {
        this.st1 = new Stack<>(); 
        this.st2 = new Stack<>(); 
        this.st1.push(homepage);  
        this.homepage = homepage;
    }
    
    public void visit(String url) {
        while(!this.st2.isEmpty()){
            this.st2.pop();
        }
        this.st1.push(url);
    }
    
    public String back(int steps) {
        int maxBackSteps = Math.min(steps, this.st1.size());

        while(maxBackSteps>0){
            if(this.st1.size()==1) break;
            String url = this.st1.pop();
            this.st2.push(url);
            maxBackSteps--;
        }

        return this.st1.peek();

    }
    
    public String forward(int steps) {
        if(this.st2.isEmpty()){
            return this.st1.peek();
        }

        int maxForwardSteps = Math.min(steps, this.st2.size());

        while(maxForwardSteps>0){
            String url = this.st2.pop();
            this.st1.push(url);
            maxForwardSteps--;
        }

        return this.st1.peek();

    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */