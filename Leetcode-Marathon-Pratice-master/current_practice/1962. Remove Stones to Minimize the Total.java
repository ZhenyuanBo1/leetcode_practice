class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int pile: piles){
            heap.add(pile);
        }

        while(k>0){
            int max = heap.remove();
            max = max - (int)Math.floor(max/2);
            heap.add(max);
            k--;
        }

        int sum = 0;

        while(!heap.isEmpty()){
            sum += heap.remove();
        }

        return sum;
    }
}