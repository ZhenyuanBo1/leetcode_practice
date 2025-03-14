class Solution {
    public int maxProduct(int[] nums) {
        int p1 = 0;
        int max = Integer.MIN_VALUE;

        while(p1 < nums.length){
            int p2 = p1;
            int product = 1;
            while(p2 < nums.length){
                product = product * nums[p2];
                max = Math.max(max, product);
                p2++;
            }
            p1++;
        }

        return max;
    }
}