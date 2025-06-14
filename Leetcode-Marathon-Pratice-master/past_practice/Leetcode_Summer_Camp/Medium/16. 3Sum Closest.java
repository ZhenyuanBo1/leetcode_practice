class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int low = i+1, high = nums.length-1;
            while(low < high){
                int sum = nums[low] + nums[high] + nums[i];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if(sum<target) low++;
                else high--;
            }
        }
        return target-diff;
    }
}