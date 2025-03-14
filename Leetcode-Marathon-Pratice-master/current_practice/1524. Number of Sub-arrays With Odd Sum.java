class Solution {
    public int numOfSubarrays(int[] arr) {
        //for each i we need to find out how many odd or even presum before it to get oddSum
        //另外，有关区间个数的题目，一般是遍历/固定一个端点，考察另一个端点的位置，这样区间的计数就不会重复和遗漏。
        long countOdd = 0, countEven = 1;
        int presum = 0;
        long M = 1000000000+7;
        long res = 0;

        for(int i=0; i<arr.length; i++){
            presum += arr[i];
            //check how many j can pair up with i to get odd sum
            if(presum % 2 == 0){
                res = (res+countOdd)%M; // when two long values add together, we need to mod M
            }else if(presum % 2 != 0){
                res = (res+countEven)%M;
            }

            if(presum % 2 == 0) countEven++;
            else countOdd++;
        }

        return (int)res;
    }
}