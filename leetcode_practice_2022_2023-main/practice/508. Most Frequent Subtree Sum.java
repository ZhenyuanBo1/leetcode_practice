/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        calculateSum(root);
        int maxFreq = Integer.MIN_VALUE;
        for(Integer key: map.keySet()){
            maxFreq = Math.max(maxFreq, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key) == maxFreq){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
    private int calculateSum(TreeNode root){
        if(root == null) return 0;
        int leftVal = calculateSum(root.left);
        int rightVal = calculateSum(root.right);
        int sum = root.val + leftVal + rightVal;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
}