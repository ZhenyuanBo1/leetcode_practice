class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length/2;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.add(num);
        }

        for(int i=0; i<nums.length;){
            nums[i] = minHeap.remove();
            i+=2;
        }

        for(int i=1; i<nums.length; ){
            nums[i] = minHeap.remove();
            i+=2;
        }


    }
}