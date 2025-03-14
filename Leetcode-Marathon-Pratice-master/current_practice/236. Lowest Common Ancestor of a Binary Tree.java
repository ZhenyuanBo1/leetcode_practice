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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = q.remove();

            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }

            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        //iterate through q's ancestor and stop when we realize the least common ancestor
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }
}