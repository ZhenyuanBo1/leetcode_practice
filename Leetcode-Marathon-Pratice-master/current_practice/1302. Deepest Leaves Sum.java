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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        q.add(nodes);

        while(!q.isEmpty()){
            List<TreeNode> currnodes = q.remove();
            int sum = 0;

            List<TreeNode> newnodes = new ArrayList<>();

            for(TreeNode node: currnodes){
                sum += node.val;
                if(node.left != null) newnodes.add(node.left);
                if(node.right != null) newnodes.add(node.right);
            }

            if(newnodes.size() == 0) return sum;

            q.add(newnodes);
        }

        return 0;
    }
}