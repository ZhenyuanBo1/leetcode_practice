class Solution {
    public int rob(int[] nums) {
        //state:
        int[] maxRobbedMoney = new int[nums.length+1];

        //initialization:
        maxRobbedMoney[0] = 0;
        maxRobbedMoney[1] = nums[0];

        //Function:
        for(int i=2; i<maxRobbedMoney.length; i++){
            maxRobbedMoney[i] = Math.max(maxRobbedMoney[i-1], maxRobbedMoney[i-2] + nums[i-1]);
        }

        //answer:
        return maxRobbedMoney[maxRobbedMoney.length-1];
    }
}