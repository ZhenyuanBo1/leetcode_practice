class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length/2;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.add(num);
            maxHeap.add(num);
        }

        for(int i=0; i<nums.length;){
            nums[i] = minHeap.remove();
            i+=2;
        }

        for(int i=1; i<nums.length; ){
            nums[i] = maxHeap.remove();
            i+=2;
        }
    }
}