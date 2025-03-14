class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1; i<=nums.length; i++){
            List<Integer> curr = new ArrayList<>();
            helper(nums, curr, res, 0, i);
        }
        res.add(new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, int index, int len){
        if(len == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums, curr, res, i+1, len-1);
            curr.remove(curr.size()-1);
        }
    }
}