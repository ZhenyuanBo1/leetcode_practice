class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = Integer.MIN_VALUE;

        for(int i: arr){
            max = Math.max(max, i);
        }

        int min = 0;

        int diff = Integer.MAX_VALUE;

        int res = 0;

        while(min < max){
            int mid = min + (max - min) / 2;
            int currSum = getSum(arr, mid);

            if(currSum > target){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

            if(Math.abs(currSum - target) < diff || Math.abs(currSum - target) == diff && mid < res){
                res = mid;
                diff = Math.abs(currSum - target);
            }
        }

        return res;
    }
    private int getSum(int[] arr, int val){
        int sum = 0;
        for(int i: arr){
            if(i > val){
                sum += val;
            }else{
                sum += i;
            }
        }
        return sum;
    }
}