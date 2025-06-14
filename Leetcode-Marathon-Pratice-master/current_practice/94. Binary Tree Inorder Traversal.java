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
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            dfs(root.left);
        }
        res.add(root.val);
        if(root.right != null){
            dfs(root.right);
        }
    }
}