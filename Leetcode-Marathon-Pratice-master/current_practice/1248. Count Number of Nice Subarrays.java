class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;

        while(right<nums.length){
            if(nums[right] % 2 != 0){
                k--;
            }

            if(k==0){
                int p = right+1;

                while(p < nums.length && nums[p]%2==0) p++;

                int suffixCount = p - right;

                //shrink window left boundary
                while(left <= right && k == 0) {
                    count += suffixCount;

                    if(nums[left]%2!=0)
                        k++;

                    left++;
                }
            }

            right++;
        }

        return count;
    }
}