class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //create a map that maps prefix sum to count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0, res = 0;
        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            if(map.containsKey(presum - goal)){
                res += map.get(presum - goal);
            }
            map.put(presum, map.getOrDefault(presum, 0)+1);
        }

        return res;
    }
}