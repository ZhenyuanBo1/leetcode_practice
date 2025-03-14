class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(curr, res, nums, visited);
        return res;
    }
    private void backtrack(List<Integer> curr, List<List<Integer>> res, int[] nums, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(curr, res, nums, visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}