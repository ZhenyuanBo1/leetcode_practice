class Solution {
    public int lastStoneWeight(int[] stones) {
        //maintain a max-heap with max at the front of the queue
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones){
            heap.add(stone);
        }

        while(heap.size()>1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if(stone1 != stone2){
                int newStone = stone1-stone2;
                heap.add(newStone);
            }
        }

        return heap.isEmpty() ? 0 : heap.remove()
    }
}