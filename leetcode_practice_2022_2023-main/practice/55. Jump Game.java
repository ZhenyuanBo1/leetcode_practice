class Solution {
    public boolean canJump(int[] nums) {
        int p = 0;
        boolean[] visited = new boolean[nums.length];

        while(p<nums.length){
            if(visited[p]) return false;
            visited[p] = true;
            int steps = nums[p];
            p = p + steps;
        }

        return true;
    }
}