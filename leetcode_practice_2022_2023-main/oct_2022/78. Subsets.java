class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=nums.length; i++){
            List<Integer> curr = new ArrayList<>();
            helper(nums, res, curr, 0, i);
        }
        res.add(new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int index, int len){
        if(len == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            helper(nums, res, curr, i+1, len-1);
            curr.remove(curr.size()-1);
        }
    }
}