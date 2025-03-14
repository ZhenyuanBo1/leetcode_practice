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
        Map<TreeNode, TreeNode> map = new HashMap<>(); //this is the map between child node and parent node
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                    map.put(node.left, node);
                }
                if(node.right != null){
                    q.offer(node.right);
                    map.put(node.right, node);
                }
            }
        }

        List<TreeNode> parentNodes = new ArrayList<>();
        parentNodes.add(p);

        while(map.containsKey(p)){
            TreeNode parent = map.get(p);
            parentNodes.add(parent);
            p = map.get(p);
        }

        while(!parentNodes.contains(q)){
            TreeNode parent = map.get(q);
            q = parent;
        }

        return q;

    }
}