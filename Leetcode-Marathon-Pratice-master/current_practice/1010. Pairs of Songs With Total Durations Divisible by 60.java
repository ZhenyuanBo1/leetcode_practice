class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //we need to calculate the number of elements b such that b%60 = 0 or b%60 = 60-a%60
        int count = 0;
        int[] rem = new int[60];

        for(int i=0; i<time.length; i++){
            if(time[i] % 60 == 0){
                count += rem[0];
            }else{
                count += rem[60-time[i]%60];
            }
            rem[time[i]%60]++;
        }

        return count;
    }
}