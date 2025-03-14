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
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                if(node.left != null){
                    parent.put(node.left, node);
                    queue.add(node.left);
                }
                if(node.right != null){
                    parent.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }

        if(!parent.containsKey(p) || !parent.containsKey(q)) return null;

        Set<TreeNode> ancestor = new HashSet<>();

        while(p!=null){
            ancestor.add(p);
            p = parent.get(p);
        }

        while(!ancestor.contains(q)){
            q = ancestor.get(q);
        }

        return q;


     }
}