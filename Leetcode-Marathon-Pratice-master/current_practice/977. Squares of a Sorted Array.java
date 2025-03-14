class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx = nums.length-1;

        //using two pointers
        int left = 0, right = nums.length-1;
        //filling higher value from the end
        while(left<=right){
            int val1 = nums[left] * nums[left];
            int val2 = nums[right] * nums[right];
            if(val1>=val2){
                res[idx--] = val1;
                left++;
            }else{
                res[idx--] = val2;
                right--;
            }
        }

        return res;
    }
}