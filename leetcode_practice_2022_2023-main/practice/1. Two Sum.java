class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i){
                return new int[]{map.get(compliment), i};
            }
        }
        
        return null;
    }
}


//one pass solution{}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i){
                return new int[]{map.get(compliment), i};
            }else{
                map.put(nums[i], i);
            }
        }
        
        return null;
    }
}