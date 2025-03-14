class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n2 - n1); // smallest element first
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        
        int res = 0;

        while(k>0){
            res = pq.poll();
            k--;
        }

        return res;
    }
}