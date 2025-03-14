class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, nums.length);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int len){
        if(len == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(Integer i: freq.keySet()){
            if(freq.get(i) == 0) continue;

            freq.put(i, freq.get(i)-1);
            curr.add(i);
            helper(res, curr, len -1 );
            curr.remove(curr.size()-1);
            freq.put(i, freq.get(i)+1);
        }
    }
}