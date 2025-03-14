class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        //any i,j pair with the largest sum less than k would be accpeted
        //thus, we can sort the array first before proceeding
        Arrays.sort(nums);
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int left = 0, right = n-1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum >= k){
                right--;
            }else{
                max = Math.max(sum, max);
                left++;
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;

    }
}