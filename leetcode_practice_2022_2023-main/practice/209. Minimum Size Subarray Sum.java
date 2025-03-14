class Solution {
    //brute force
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[target.length+1];
        sum[0] = 0;

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=nums.length; i++){
            sum[i] = nums[i-1] + sum[i-1];
        }

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<=nums.length; j++){
                int diff = sum[j] - sum[i];
                if(diff >= target){
                    min = Math.min(min, diff);
                }
            }
        }

        return min;
    }
}


class Solution {
    //using two pointers
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        
        int len = Integer.MAX_VALUE;
        
        while(right<nums.length){
            sum += nums[right];
            while(sum >= target){
                len = Math.min(len, right-left+1);
                sum -= nums[left++];
            }
            right++;
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
