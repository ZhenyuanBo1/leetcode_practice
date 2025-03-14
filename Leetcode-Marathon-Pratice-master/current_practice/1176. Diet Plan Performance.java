class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int left = 0;
        int right = 0;
        int points = 0;
        int currSum = 0;

        while(right<calories.length){
            if(right-left+1 == k){
                currSum += calories[right++];
                if(currSum < lower){
                    points--;
                }else if(currSum > upper){
                    points++;
                }
                currSum -= calories[left++];
            }else if(right-left+1 < k){
                currSum += calories[right++];
            }
        }

        return points;
    }
}