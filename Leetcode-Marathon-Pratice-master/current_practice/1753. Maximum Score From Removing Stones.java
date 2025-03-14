class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.add(a);
        heap.add(b);
        heap.add(c);

        int score = 0, count = 0;

        while(true){
            int max1 = heap.remove();
            int max2 = heap.remove();
            if(max1>0){
                max1 -=1;
                count +=1;
            }
            if(max2>0){
                max2 -=1;
                count +=1;
            }
            if(count < 2) break;
            score += 1;
            heap.add(max1);
            heap.add(max2);
            count = 0;
        }

        return score;
    }
}