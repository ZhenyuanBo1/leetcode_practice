/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q_o = new LinkedList<>();
        Queue<TreeNode> q_c = new LinkedList<>();
        q_o.add(original);
        q_c.add(cloned);

        while(!q_o.isEmpty()){
            TreeNode node_o = q_o.remove();
            TreeNode node_c = q_c.remove();

            if(node_o.equals(target)){
                return node_c;
            }

            if(node_o.left != null) q_o.add(node_o.left);
            if(node_o.right != null) q_o.add(node_o.right);

            if(node_c.left != null) q_c.add(node_c.left);
            if(node_c.right != null) q_c.add(node_c.right);
        }

        return null;
    }
}