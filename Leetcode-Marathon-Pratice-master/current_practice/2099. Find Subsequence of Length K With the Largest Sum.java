class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //maintain min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            heap.add(nums[i]);
        }

        while(heap.size() > k){
            heap.remove();
        }

        List<Integer> numList = new ArrayList<>();

        while(!heap.isEmpty()){
            numList.add(heap.remove());
        }

        int[] res = new int[k];
        int j = 0;

        for(int i=0; i<nums.length; i++){
            if(j>=k) break;
            if(numList.contains(nums[i])){
                numList.remove((Integer)nums[i]);
                res[j++] = nums[i];
            }
        }

        return res;

    }
}