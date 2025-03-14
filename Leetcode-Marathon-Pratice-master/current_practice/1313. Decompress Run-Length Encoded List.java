class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(2*i < nums.length){
                int freq = nums[2*i];
                int val = nums[2*i + 1];
                while(freq > 0){
                    res.add(val);
                    freq -= 1;
                }
            }
        }
        int [] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}