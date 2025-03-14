class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2-n1);

        for(int i=0; i<nums2.length; i++){
            pq.add(nums2[i]);
        }

        int sum = 0;

        for(int i=0; i<nums1.length; i++){
            sum += nums1[i] * pq.poll();
        }

        return sum;
    }
}