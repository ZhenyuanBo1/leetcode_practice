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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        dfs(root, vals);

        TreeNode dummy = new TreeNode();
        TreeNode curr = dummy;

        for(Integer val: vals){
            curr.right = new TreeNode(val);
            curr = curr.right;
        }

        return dummy.right;

    }
    private void dfs(TreeNode node, List<Integer> vals){
        if(node == null) return;
        dfs(node.left, vals);
        vals.add(node.val);
        dfs.(node.right, vals);
    }
}