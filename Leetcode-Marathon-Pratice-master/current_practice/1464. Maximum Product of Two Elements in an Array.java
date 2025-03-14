class Solution {
    public int maxProduct(int[] nums) {

        Arrays.sort(nums);

        int largest = nums[nums.length-1];
        int secLargest = nums[nums.length-2];

        return (largest-1)*(secLargest-1);
    }
}