class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        for(Integer key: freq.keySet()){
            if(freq.get(key) >= 2) return true;
        }

        return false;
    }
}