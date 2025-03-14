class Solution {
    public int minSubarray(int[] nums, int p) {
        //for subarray question, we need to fix one point and look for the other point
        //in this question, we fix the right most point and look for the left most point
        //sum[i:j] = presum[j] - presum[i-1]
        long totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum = (totalSum + nums[i])%p;
        }
        long r = totalSum % p;

        if(r % p == 0) return 0;

        long presum = 0;

        int ret = Integer.MAX_VALUE;

        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, -1);

        for(int i=0; i<nums.length; i++){
            presum = (presum + nums[i])%p;
            long r1 = presum % p;
            long targetR = (r1-r + p) % p;
            if(map.containsKey(targetR)){
                int index = map.get(targetR) + 1;
                ret = Math.min(ret, i-index+1);
            }
            //overwrite the previous value in order to find the smallest subarray
            map.put(r1, i);
        }

        return ret < nums.length ? ret : -1;

    }
}