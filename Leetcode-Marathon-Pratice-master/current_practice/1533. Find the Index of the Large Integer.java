/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int len = reader.length();
        int left = 0, right = len-1, res = 0;

        while(left < right){
            int mid = left + (right-left)/2;
            if((right-left+1) % 2 == 0){
                res = reader.compareSub(left, mid, mid+1, right);
            }else{
                res = reader.compareSub(left, mid, mid, right);
            }
            // System.out.println(res+ " " + mid + " " + left + " " + right);
            if(res == 1){
                right = mid;
            }else if(res == -1){
                left = mid+1;
            }else{
                left = mid;
            }
        }

        if(left == right) return left;

        return -1;
    }
}