class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int stick: sticks){
            heap.add(stick);
        }

        int cost = 0;
        while(heap.size() > 1){
            int x = heap.remove();
            int y = heap.remove();
            cost += x + y;
            heap.add(x+y);
        }

        return cost;
    }
}