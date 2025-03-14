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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null) return root2;
        if(root1 != null && root2 == null) return root1;
        if(root1 == null && root2 == null) return null;

        //we can use left tree as the reference tree
        Queue<TreeNode[]> q = new LinkedList<>();

        q.add(new TreeNode[]{root1, root2});

        while(!q.isEmpty()){
            TreeNode[] nodes = q.remove();
            if(nodes[1] != null){
                nodes[0].val += nodes[1].val;

                if(nodes[0].left == null){
                    nodes[0].left = nodes[1].left;
                }else{
                    q.add(new TreeNode[]{nodes[0].left, nodes[1].left});
                }

                if(nodes[0].right == null){
                    nodes[0].right = nodes[1].right;
                }else{
                    q.add(new TreeNode[]{nodes[0].right, nodes[1].right});
                }
            }
        }

        return root1;
    }
}