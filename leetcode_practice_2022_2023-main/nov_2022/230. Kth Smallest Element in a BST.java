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
    //using in-order traversal if we want to sort the bst in ordered list
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        int targetIndex = k-1;
        return res.get(targetIndex);
    }
    private void helper(List<Integer> res , TreeNode root){
        if(root.left != null){
            helper(res, root.left);
        }
        res.add(root.val);
        if(root.right != null){
            helper(res, root.right);
        }
    }
}