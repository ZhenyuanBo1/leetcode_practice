class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0, ret = 0;
        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            //this is to cover the scenario where presum is negative
            int r = (presum%k+k) % k;
            if(map.containsKey(r)){
                ret += map.get(r);
            }
            map.put(r, map.getOrDefault(r, 0)+1);
        }

        // System.out.println(map);

        return ret;
    }
}