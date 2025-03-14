class Solution {
    public int minStartValue(int[] nums) {
        int pos = 1;
        while(true){
            int prefixSum = pos;
            boolean found = false;
            for(int j=0; j<nums.length; j++){
                prefixSum += nums[j];
                if(prefixSum < 1){
                    found = true;
                    break;
                }
            }
            if(!found) return pos;
            pos++;
        }
    }
}