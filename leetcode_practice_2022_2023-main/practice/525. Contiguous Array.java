class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, -1);
        int max = 0;

        for(int i=0; i<nums.length; i++){
            count += (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)){
                max = Math.max(max, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }

        return max;
    }
}