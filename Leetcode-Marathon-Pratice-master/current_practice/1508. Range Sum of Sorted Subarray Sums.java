class Solution {
    /*
    this question needs investigation from instructor Guan
    */
    public int rangeSum(int[] nums, int n, int left, int right) {

        int sum = 0, M = (int)Math.pow(10, 9) + 7;

        for(int i=left; i<=right; i++){
            sum = (sum + calculateKthSmallestSum(i, nums)) % M;
        }

        return sum;
    }

    private int calculateKthSmallestSum(int k, int[] nums){
        int totalSum = 0;

        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }

        int left = 1, right = totalSum;

        while(left < right){
            int mid = left + (right-left)/2;
            if(countSmallerOrEqual(mid, nums) >= k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        // System.out.println(left);
        return left;
    }

    private int countSmallerOrEqual(int mid, int[] nums){
        int j = 0;
        int count = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            while(j<nums.length && sum + nums[j]<=mid){
                sum += nums[j];
                j++;
            }
            count += j-i;
            sum -= nums[i];
        }
        return count;
    }
}