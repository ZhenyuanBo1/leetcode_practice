class Solution {
    public int[] productExceptSelf(int[] nums) {
        //create two array - left array and right array
        //left array: stores all the results multiply together up to current index
        //right array: store all the results multiply toegether from right up to current index
        //for each position, left * right

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[right.length-1] = 1;

        for(int i=1; i<nums.length; i++){
            left[i] = nums[i-1] * left[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}

class Solution{
    public int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];

        ans[0] = 1;

        for(int i=1; i<nums.length; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }

        int r = 1;

        for(int i=nums.length-1; i>=0; i--){
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;
    }
}