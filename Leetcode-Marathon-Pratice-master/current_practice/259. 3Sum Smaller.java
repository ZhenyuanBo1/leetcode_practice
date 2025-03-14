class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        for(int i=0; i<nums.length; i++){
            //check two sum
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] + nums[i] < target){
                    count += r-l; //count # of triplets smaller than target
                    l++;
                }else{
                    r--;
                }
            }
        }
        return count;
    }
}