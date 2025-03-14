class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1;
        int duplicate = 0;

        //using binary search o(logn) and iterate through each item in the nums, o(n)
        //final time complexity would be o(nlogn)

        while(l<=r){
            int mid = l + (r-l)/2;
            int count=0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count>mid){
                duplicate = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return duplicate;

    }
}