class Solution {
    public int jump(int[] nums) {
        //using BFS and Greedy Algo
        int start = 0, end = 0;
        int steps = 0;

        if(nums.length == 1) return 0;

        while(start <= end){
            int newEnd = end;
            for(int i=start; i<=end; i++){
                newEnd = Math.max(newEnd, nums[i] + i);
                //as it is guaranteed to reach the end index
                if(newEnd >= nums.length-1) return steps+1;
            }
            start = end + 1;
            end = newEnd;
            steps++;
        }

        return -1;
    }
}