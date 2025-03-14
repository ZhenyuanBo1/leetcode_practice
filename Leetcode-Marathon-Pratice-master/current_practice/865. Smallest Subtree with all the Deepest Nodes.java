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
class Pair{
    TreeNode node;
    TreeNode parent;
    Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;

        Map<TreeNode, Pair> map = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, null));

        List<Pair> deepestNodes = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            List<Pair> currLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                Pair p = q.remove();
                currLevel.add(p);
                map.put(p.node, p);
                if(p.node.left != null) q.add(new Pair(p.node.left, p.node));
                if(p.node.right != null) q.add(new Pair(p.node.right, p.node));
            }
            deepestNodes = currLevel;
        }

        for(Pair p: deepestNodes){
            q.add(p);
        }

        if(q.size() == 1){
            Pair p = q.remove();
            return p.node;
        }

        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> parents = new ArrayList<>();
            for(int i=0; i<size; i++){
                Pair p = q.remove();
                TreeNode par = p.parent;
                if(!parents.contains(par)){
                    Pair parP = map.get(par);
                    q.add(parP);
                    parents.add(par);
                }
            }
            if(parents.size() == 1) return parents.get(0);
        }

        return null;

    }
}