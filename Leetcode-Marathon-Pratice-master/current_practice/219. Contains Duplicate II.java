class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int right=0;
        int left=0;

        while(right<nums.length){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                if(set.size() > k){
                    set.remove(nums[left++]);
                }
                right += 1;
            }else{
                return true;
            }
        }

        return false;
    }
}