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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;

        Queue<List<Pair>> q = new LinkedList<>();
        List<Pair> nodes = new ArrayList<>();
        nodes.add(new Pair(root, null));
        q.add(nodes);

        List<Pair> last = new ArrayList<>();

        Map<TreeNode, Pair> map = new HashMap<>();

        while(!q.isEmpty()){
            List<Pair> currnodes = q.remove();
            List<Pair> newnodes = new ArrayList<>();
            for(Pair currpair: currnodes){
                map.put(currpair.node, currpair);
                if(currpair.node.left != null){
                    newnodes.add(new Pair(currpair.node.left, currpair.node));
                }
                if(currpair.node.right != null){
                    newnodes.add(new Pair(currpair.node.right, currpair.node));
                }
            }
            if(newnodes.size() == 0){
                if(currnodes.size() == 1) return currnodes.get(0).node;
                last = currnodes;
                break;
            }
            q.add(newnodes);
        }

        //go back up to get the lowest ancestor
        Queue<List<Pair>> q1 = new LinkedList<>();
        q1.add(last);

        while(!q1.isEmpty()){
            List<Pair> currPair = q1.remove();
            List<TreeNode> ancestors = new ArrayList<>();
            List<Pair> newPair = new ArrayList<>();

            for(Pair p: currPair){
                if(!ancestors.contains(p.parent)) ancestors.add(p.parent);
                newPair.add(map.get(p.parent));
            }
            if(ancestors.size() == 1) return ancestors.get(0);
            q1.add(newPair);
        }

        return null;
    }
}