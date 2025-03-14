class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int n = nums.length;
        int idx = a >= 0 ? n - 1 : 0; // if 'a' >= 0, start filling from end (meaning higher elements first at end), if 'a' < 0, start filling from start (smaller first)
        int i = 0, j = n - 1;

        while(i <= j) {
            if(a >= 0) {
                int startVal = calc(nums[i], a, b, c);
                int endVal = calc(nums[j], a, b, c);
                if(startVal >= endVal) {
                    res[idx] = startVal;
                    i++;
                } else {
                    res[idx] = endVal;
                    j--;
                }
                idx--;
            } else {
                int startVal = calc(nums[i], a, b, c);
                int endVal = calc(nums[j], a, b, c);
                if(startVal >= endVal) {
                    res[idx] = endVal;
                    j--;
                } else {
                    res[idx] = startVal;
                    i++;
                }
                idx++;
            }
        }

        return res;
    }

    private int calc(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}