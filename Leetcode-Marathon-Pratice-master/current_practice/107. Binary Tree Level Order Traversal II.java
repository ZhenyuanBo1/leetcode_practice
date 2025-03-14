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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> s = new Stack<>();
        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        q.add(nodes);

        while(!q.isEmpty()){
            List<TreeNode> currnodes = q.remove();
            List<TreeNode> newnodes = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();

            for(TreeNode node: currnodes){
                vals.add(node.val);
                if(node.left != null){
                    newnodes.add(node.left);
                }
                if(node.right != null){
                    newnodes.add(node.right);
                }
            }

            s.push(vals);
            if(newnodes.size() == 0) break;

            q.add(newnodes);
        }

        List<List<Integer>> ans = new ArrayList<>();

        while(!s.isEmpty()){
            ans.add(s.pop());
        }

        return ans;
    }
}