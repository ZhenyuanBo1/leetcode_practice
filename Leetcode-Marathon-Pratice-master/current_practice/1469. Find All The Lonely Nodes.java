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
    public List<Integer> getLonelyNodes(TreeNode root) {
        //using BFS - check one layer at a time
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr.left == null && curr.right != null){
                res.add(curr.right.val);
            }
            if(curr.right == null && curr.left != null){
                res.add(curr.left.val);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            if(curr.left != null){
                q.add(curr.left);
            }
        }

        return res;
    }
}