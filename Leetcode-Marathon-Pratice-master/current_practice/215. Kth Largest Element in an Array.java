class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        int count=1;
        int index = nums.length-1;

        while(count < k){
            index--;
            count++;
        }

        return nums[index];
    }
}

//Using Binary Search By Value
class Solution {
    public int findKthLargest(int[] nums, int k) {
        long left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;

        while(left < right){
            long targetVal = right - (right-left)/2;
            if(countGreaterOrEqual(nums, targetVal)>=k){
                left = targetVal;
            }else{
                right = targetVal-1;
            }
        }

        return (int)left;
    }

    private int countGreaterOrEqual(int[] nums, long targetVal){
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= targetVal){
                count++;
            }
        }
        return count;
    }
}