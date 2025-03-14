class PhoneDirectory {
    private Queue<Integer> pq;

    public PhoneDirectory(int maxNumbers) {
        this.pq = new PriorityQueue<>();

        for(int i=0; i<maxNumbers; i++){
            this.pq.add(i);
        }
    }

    public int get() {
        if(!pq.isEmpty()) return pq.poll();
        return -1;
    }

    public boolean check(int number) {
        return pq.contains(number);
    }

    public void release(int number) {
        if(!pq.contains(number)) pq.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */