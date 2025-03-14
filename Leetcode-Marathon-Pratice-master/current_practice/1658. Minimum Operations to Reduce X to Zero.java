class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> presumMap = new HashMap<>();
        presumMap.put(0, -1);

        int presum = 0;
        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            if(!presumMap.containsKey(presum)) presumMap.put(presum, i);
        }

        int min = Integer.MAX_VALUE;
        if(presumMap.containsKey(x)){
            min = presumMap.get(x)+1;
        }

        int sufsum = 0;
        for(int j=nums.length-1; j>=0; j--){
            sufsum += nums[j];
            int target = x - sufsum;
            if(presumMap.containsKey(target)){
                if(presumMap.get(target) < j)
                    min = Math.min(min, presumMap.get(target)+1 + nums.length-j);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}