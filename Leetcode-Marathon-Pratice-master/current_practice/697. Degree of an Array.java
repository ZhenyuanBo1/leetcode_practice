class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
        right = new HashMap<>(),
        count = new HashMap<>();
        /*
        1. find the left most of the item
        2. find the right most of the item
        3. difference is the shortest length
        */
        for(int i = 0; i<nums.length; i++){
            if(left.get(nums[i]) == null) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        int degree = Collections.max(count.values());

        int res = nums.length;

        for(Integer val: count.keySet()){
            if(count.get(val) == degree){
                res = Math.min(res, right.get(val) - left.get(val) + 1);
            }
        }

        return res;
    }
}