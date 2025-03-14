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
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public void flatten(TreeNode root) {
        if(root == null) return ;
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
        helper(root);

        while(!st1.isEmpty()){
            this.st2.push(this.st1.pop());
        }

        TreeNode p = root;
        
        st2.pop();

        while(!st2.isEmpty()){
            TreeNode node = new TreeNode(st2.pop());
            p.right = node;
            p.left = null;
            p = node;
        }

    }
    private void helper(TreeNode root){
        st1.push(root.val);
        if(root.left != null){
            helper(root.left);
        }
        if(root.right != null){
            helper(root.right);
        }
    }
}