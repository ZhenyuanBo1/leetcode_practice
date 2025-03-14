class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int index=0;
        int[] res = new int[nums.length-k+1];

        while(right<nums.length){

            int count = map.getOrDefault(nums[right], 0)+1;
            map.put(nums[right], count);

            if(right-left + 1 == k){
                int distinctCount = map.size();
                res[index++] = distinctCount;
                int updatedVal = map.get(nums[left])-1;
                if(updatedVal == 0){
                    map.remove(nums[left++]);
                }else{
                    map.put(nums[left++], updatedVal);
                }

            }

            right++;
        }

        return res;
    }

}