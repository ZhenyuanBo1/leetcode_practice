class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        int j=1;
        for(int i=0; i<nums.length; i++){
            if(j<=i){
                j = i+1;
            }
            while(j<nums.length && nums[j]-nums[i]<k){
                j++;
            }
            if(j<nums.length && nums[j] - nums[i] == k){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], nums[j]);
                }
            }
        }
        return map.size();
    }
}