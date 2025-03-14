class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count=0;

        boolean firstCond = false;
        boolean secondCond = false;
        boolean thirdCond = false;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    firstCond = Math.abs(arr[i] - arr[j])<=a;
                    secondCond = Math.abs(arr[j]-arr[k])<=b;
                    thirdCond = Math.abs(arr[i]-arr[k])<=c;
                    if(firstCond && secondCond && thirdCond){
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}