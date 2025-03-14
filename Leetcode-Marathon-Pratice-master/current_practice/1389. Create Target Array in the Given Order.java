class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            int idx = index[i];
            res.add(idx, val);
        }

        int[] ans = new int[res.size()];

        for(int j=0; j<res.size(); j++){
            ans[j] = res.get(j);
        }

        return ans;
    }
}