class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
            heap.add(num);
        }

        int[] res = new int[nums.length];

        int i=0;
        while(!heap.isEmpty()){
            res[i++] = heap.remove();
        }

        return res;
    }
}