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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        q.add(list);

        int depth = 0;

        while(!q.isEmpty()){
            List<TreeNode> currDepth = q.remove();
            depth += 1;

            List<TreeNode> newDepth = new ArrayList<>();
            for(int i=0; i<currDepth.size(); i++){
                if(currDepth.get(i).left != null){
                    newDepth.add(currDepth.get(i).left);
                }
                if(currDepth.get(i).right != null){
                    newDepth.add(currDepth.get(i).right);
                }
            }
            if(newDepth.size() == 0) break;
            q.add(newDepth);
        }

        return depth;
    }
}