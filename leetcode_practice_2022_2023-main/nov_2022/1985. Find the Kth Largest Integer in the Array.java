class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((n1, n2)->{
            if(n1.length() == n2.length()){
                return n1.compareTo(n2);
            }
            return Integer.compare(n1.length(), n2.length());
        });

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}