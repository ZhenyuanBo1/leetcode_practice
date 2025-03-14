class KthLargest {
    //maintain a min-heap
    //min means that the heap will remove/find the smallest element, a max heap is the same thing but for the largest element
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int num: nums){
            heap.add(num);
        }
        while(heap.size()>k){
            heap.remove();
        }
    }

    public int add(int val) {
        this.heap.add(val);
        if(heap.size()>k){
            heap.remove();
        }
        return heap.peek();
    }
}

//TreeMap<Integer,Integer> tm= new TreeMap<>(Collections.reverseOrder());