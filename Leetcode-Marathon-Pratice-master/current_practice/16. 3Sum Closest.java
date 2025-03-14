class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;

        for(int i=0; i<nums.length; i++){
            int sum = target - nums[i];
            //2 sum closest
            int l = i+1, r = nums.length-1;
            while(l<r){
                //record current closest
                if(Math.abs(nums[l] + nums[r] - sum) < diff){
                    diff = Math.abs(nums[l] + nums[r] - sum);
                    res = nums[l] + nums[r] + nums[i];
                }

                if(nums[l]+nums[r] > sum){
                    r--;
                }else if(nums[l] + nums[r] < sum){
                    l++;
                }else{
                    return target;
                }
            }
        }

        return res;
    }
}