class Solution {
    //using hashset to remove duplicates instead of using contains to check
    Set<List<Integer>> lists;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.lists = new HashSet<>();

        List<Integer> curr = new ArrayList<>();
        
        for(int i=2; i<=nums.length; i++){
            helper(curr, nums, i, 0);
        }
        
        return new ArrayList<>(lists);
    }
    private void helper(List<Integer> curr, int[] nums, int len, int index){
        if(len == 0){
            this.lists.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(curr.size() == 0 || nums[i] >= curr.get(curr.size()-1)){
                curr.add(nums[i]);
                helper(curr, nums, len - 1, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}