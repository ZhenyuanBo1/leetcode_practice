class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> freq = new HashMap<>();

        List<Integer> indices = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        int ans = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == key) indices.add(i);
        }

        for(Integer index: indices){
            if(index+1 < nums.length){
                freq.put(nums[index+1], freq.getOrDefault(nums[index+1], 0) + 1);
                if(freq.get(nums[index+1]) >= max){
                    ans = nums[index+1];
                    max = Math.max(max, freq.get(nums[index+1]));
                }
            }
        }

        return ans;

    }
}