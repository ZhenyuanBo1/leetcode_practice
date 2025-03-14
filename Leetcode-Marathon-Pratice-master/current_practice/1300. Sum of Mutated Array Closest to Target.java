class Solution {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        if(sum < target){
            Arrays.sort(arr);
            return arr[arr.length-1];
        }

        int left = 0, right = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right - left)/2;
            if(calculateSum(mid, arr) >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        //check if there is any value less than this current left
        int sum1 = calculateSum(left, arr);
        int sum2 = calculateSum(left-1, arr);

        if(Math.abs(sum1-target) < Math.abs(sum2 - target)){
            return left;
        }

        return left-1;
    }

    private int calculateSum(int mid, int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>mid){
                sum += mid;
            }else{
                sum += arr[i];
            }
        }
        System.out.println("mid: " + mid + " sum: " + sum);
        return sum;
    }
}