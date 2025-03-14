class Solution {
    private int M = 1000000000 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        long count = 0;

        //in subsequence, some values can be included and excluded
        //for every value, there are two possibilities
        int j = 0;
        for(int i=0; i<nums.length; i++){
            while(j>=i && nums[j] + nums[i] > target){
                j--;
            }
            if(j<i) break;
            count = (count + power(j-i))%M;
        }

        return (int)(count%M);
    }

    private long power(int exp){
        if(exp == 0) return 1;

        long half = power(exp/2);

        if(exp % 2 == 0){
            return half * half%M
        }else{
            return (half * half * 2)%M
        }
    }
}

class Solution {
    private int M = 1000000000 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;

        int[] power = new int[nums.length+1];

        power[0] = 1;

        //pre-calculate the all the possible powers
        for(int i=1; i<power.length; i++){
            power[i] = (2*power[i-1])%M;
        }

        //in subsequence, some values can be included and excluded
        //for every value, there are two possibilities
        int j = nums.length-1;
        for(int i=0; i<nums.length; i++){
            while(j>=i && nums[j] + nums[i] > target){
                j--;
            }
            if(j<i) break;
            count = (count + power[j-i])%M;
        }

        return count%M;
    }
}