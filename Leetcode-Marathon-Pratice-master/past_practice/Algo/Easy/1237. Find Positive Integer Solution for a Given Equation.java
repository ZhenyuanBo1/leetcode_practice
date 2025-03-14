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
        List<List<Integer>> resList = new ArrayList<>();
        int x=1, y=z;
        while(x<=z && y>0){
            int res = customfunction.f(x, y);
            if(res>z) y--;
            else if(res<z) x++;
            else
                resList.add(Arrays.asList(x++, y--));
        }
        return resList;
    }
}