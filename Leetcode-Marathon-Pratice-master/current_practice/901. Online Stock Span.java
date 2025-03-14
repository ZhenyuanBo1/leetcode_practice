class StockSpanner {
    private Stack<List<Integer>> st;
    private List<Integer> list;
    private int j;

    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
        j = 0;
    }

    public int next(int price) {
        if(st.isEmpty() || st.peek().get(0) > price){
            st.push(Arrays.asList(price, j));
            list.add(j, 1);
            j++;
            return 1;
        }else{
            int count = 0;
            while(!st.isEmpty() && st.peek().get(0) <= price){
                count += list.get(st.peek().get(1));
                st.pop();
            }
            st.push(Arrays.asList(price, j));
            list.add(j, count+1);
            j++;
            return count+1;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */