class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<>();
        int removeCount = nums.length - k;

        for(int i=0; i<nums.length; i++){
            if((s.isEmpty() || s.peek()<=nums[i])){
                s.push(nums[i]);
            }else{
                while(!s.isEmpty() && s.peek()>nums[i] && removeCount>0){
                    s.pop();
                    removeCount--;
                }
                s.push(nums[i]);
            }
        }

        while(!s.isEmpty() && s.size()>k){
            s.pop();
        }

        int[] res = new int[s.size()];

        for(int i = res.length-1; i>=0; i--){
            res[i] = s.pop();
        }

        return res;
    }
}