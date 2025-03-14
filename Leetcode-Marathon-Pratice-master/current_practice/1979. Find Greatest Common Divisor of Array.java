class Solution {
    public int findGCD(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>largest){
                largest = nums[i];
            }
        }
        int smallest = Integer.MAX_VALUE;
        for(int j=0; j<nums.length; j++){
            if(nums[j]<smallest){
                smallest = nums[j];
            }
        }
        int gcd = 1;

        for(int i=1; i<=largest && i<=smallest; i++){
            if(largest%i==0 && smallest%i==0){
                gcd = i;
            }
        }

        return gcd;
    }
}