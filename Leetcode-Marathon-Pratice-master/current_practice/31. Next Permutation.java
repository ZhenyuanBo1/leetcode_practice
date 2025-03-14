class Solution {
    public void nextPermutation(int[] nums) {
        int lowerPos = 0;
        boolean found = false;

        //find the position where value needs to be increased
        for(int i=nums.length-1; i-1>=0; i--){
            if(nums[i]>nums[i-1]){
                found = true;
                lowerPos = i-1;
                break;
            }
        }

        //if not found, sort the array in ascending order
        if(!found){
            Arrays.sort(nums);
            return;
        }

        //find the value that is greater than value at lowerPos
        for(int i=nums.length-1; i>lowerPos; i--){
            if(nums[i] > nums[lowerPos]){
                int temp = nums[lowerPos];
                nums[lowerPos] = nums[i];
                nums[i] = temp;
                break;
            }
        }


        //sort the remaining part
        Arrays.sort(nums, lowerPos+1, nums.length);

    }
}