class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length/2];

        int minStepsOdd = 0;

        for(int i=0; i<nums.length; i++){
            minStepsOdd += Math.abs(nums[i] - mid); 
        }

        if(nums.length % 2 == 0){
            int minStepsEven = 0;
            int midEven = nums[nums.length/2-1];

            for(int j = 0; j<nums.length; j++){
                minStepsEven += Math.abs(nums[j] - midEven);
            }

            return Math.min(minStepsOdd, minStepsEven);
        }

        return minStepsOdd;


    }
}