class Solution {
    public void wiggleSort(int[] nums) {
        //alternative solution: pair wise compare
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2)->n1-n2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2)->n2-n1);

        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
        }

        for(int i=0; i<nums.length;){
            nums[i] = minHeap.poll();
            if(i+1<nums.length) nums[i+1] = maxHeap.poll();
            i+=2;
        }
    }
}