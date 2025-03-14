/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=1000; i++){
            //fix one value and look for the other one
            int y = getY(customfunction, i, z);
            if(y != -1){
                List<Integer> subList = new ArrayList<>();
                subList.add(i);
                subList.add(y);
                res.add(subList);
            }
        }

        return res;

    }

    private int getY(CustomFunction customfunction, int x, int z){
        int left = 1, right = 1000;

        while(left < right){
            int mid = left + (right - left)/2;
            int val = customfunction.f(x, mid);
            if(val > z){
                right = mid - 1;
            }else if(val < z){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        if(left == right && customfunction.f(x, left) == z) return left;

        return -1;

    }
}