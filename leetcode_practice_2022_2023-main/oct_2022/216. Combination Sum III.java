class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        helper(res, curr, 0, k, n, nums);
        return res;
    }
    private void helper(List<List<Integer>> res , List<Integer> curr, int index, int k, int n, int[] nums){
        if(k==0 && n==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            helper(res, curr, i+1, k-1, n-nums[i], nums);
            curr.remove(curr.size()-1);
        }
    }
}