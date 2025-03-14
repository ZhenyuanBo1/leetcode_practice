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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        node.add(root);
        q.add(nodes);

        int level = -1;
        while(!q.isEmpty()){
            List<TreeNode> currnodes = q.remove();
            level += 1;

            List<TreeNode> newnodes = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();

            for(TreeNode node: currnodes){
                vals.add(node.val);
                if(node.left != null) newnodes.add(node.left);
                if(node.right != null) newnodes.add(node.right);
            }

            if(level % 2 != 0){
                //reverse
                Collections.reverse(vals);
            }

            ans.add(vals);
            if(newnodes.size() == 0) break;
            q.add(newnodes);
        }

        return ans;


    }
}