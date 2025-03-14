class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //a pair of presum[i] and presum[j] gives the difference that is equal to k
        //this is essential a variation of two sum problem
        int[] presum = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();

        //calculate the presum
        for(int i=0; i<nums.length; i++){
            presum[i+1] = presum[i] + nums[i];
        }

        int max = 0;

        //iterate through the entire presum to find the pair where presum[j] - presum[i] == k
        //this is essentially a variation of two sum problem
        for(int i=0; i<presum.length; i++){
            int target = presum[i] - k;
            if(map.containsKey(target)){
                max = Math.max(max, i-map.get(target));
            }
            if(!map.containsKey(presum[i])){
                map.put(presum[i], i);
            }
        }

        return max;


    }
}