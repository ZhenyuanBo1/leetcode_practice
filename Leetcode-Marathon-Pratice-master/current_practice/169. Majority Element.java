class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int j = 0, i=0;
        while(i<nums.length){
            while(j+1<nums.length && nums[j] == nums[j+1]){
                j++;
            }
            if(j-i+1 > nums.length/2) return nums[j];
            j++;
            i = j;
        }

        return -1;
    }
}