class Solution {
    //using prefix sum algorithm
    public int subarraysDivByK(int[] nums, int k) {
        /*
        we basically look for how many j's have the same remainder as the current one
        we can use hashmap to perform this look up
        prefix[i] % k = r, prefix[j] % k = r, prefix[j:i] % k = 0; ---> this is the rule!
        */

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;

        int count = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int r = (prefixSum % k + k)%k;
            count += map.getOrDefault(r, 0);
            map.put(r, map.getOrDefault(r, 0)+1);
        }

        return count;
    }
}