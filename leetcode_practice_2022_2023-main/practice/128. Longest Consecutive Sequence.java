class Solution {
    private Set<Integer> set;
    private Set<Integer> visited;
    public int longestConsecutive(int[] nums) {
        this.set = new HashSet<>();
        this.visited = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            int next = nums[i] + 1;
            int prev = nums[i] - 1;
            int count1 = 0;
            //for descending 
            while(set.contains(prev)){
                visited.add(prev);
                prev -= 1;
                count1++;
            }
            int count2 = 0;
            //for ascending
            while(set.contains(next)){
                visited.add(next);
                next += 1;
                count2++;
            }
            max = Math.max(max, count1+count2+1);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}