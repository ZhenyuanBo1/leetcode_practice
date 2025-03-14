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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add(String.valueOf(root.val));
        helper(res, curr, root);
        int sum = 0;
        for(String str: res){
            sum += Integer.valueOf(str);
        }
        return sum;
    }

    private void helper(List<String> res, List<String> curr, TreeNode root){
        if(root.left == null && root.right == null){
            String currStr = String.join("", curr);
            res.add(currStr);
            return;
        }

        if(root.left != null){
            curr.add(String.valueOf(root.left.val));
            helper(res, curr, root.left);
            curr.remove(curr.size()-1);
        }

        if(root.right != null){
            curr.add(String.valueOf(root.right.val));
            helper(res, curr, root.right);
            curr.remove(curr.size()-1);
        }
    }
}