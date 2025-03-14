/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 10000;

        while(left < right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) < target){
                left = mid + 1;
            }else if(reader.get(mid) > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }

        if(left == right && reader.get(left) == target) return left;

        return -1;
    }
}