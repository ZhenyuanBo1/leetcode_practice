class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int count = 0;

        for(int i=1; i<=nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
            System.out.println(sum[i]);
        }



        for(int j=0; j<nums.length; j++){
            for(int l=j+1; l<=nums.length; l++){
                if(sum[l] - sum[j] == k){
                    count += 1;
                }
            }
        }

        return count;
    }
}