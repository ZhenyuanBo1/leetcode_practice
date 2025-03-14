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
    public TreeNode node;
    public TreeNode parent;
    public TreeNode grandparent;
    Pair(TreeNode node, TreeNode parent, TreeNode grandparent){
        this.node = node;
        this.parent = parent;
        this.grandparent = grandparent;
    }
}
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, null, null));

        int ans = 0, depth = 1;
        while(!q.isEmpty()){
            int currsize = q.size();

            //visit each level
            for(int i=0; i<currsize; i++){
                Pair currpair = q.remove();
                if(depth >= 3){
                    if(currpair.grandparent.val % 2 == 0){
                        ans += currpair.node.val;
                    }
                }
                if(currpair.node.left != null){
                    if(depth == 1){
                        q.add(new Pair(currpair.node.left, currpair.node, null));
                    }else{
                        q.add(new Pair(currpair.node.left, currpair.node, currpair.parent));
                    }
                }

                if(currpair.node.right != null){
                    if(depth == 1){
                        q.add(new Pair(currpair.node.right, currpair.node, null));
                    }else{
                        q.add(new Pair(currpair.node.irhgt, currpair.node, currpair.parent));
                    }
                }
            }

            depth += 1;
        }

        return ans;
    }
}