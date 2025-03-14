class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, res, curr, visited);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res , List<Integer> curr, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, res, curr, visited);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}