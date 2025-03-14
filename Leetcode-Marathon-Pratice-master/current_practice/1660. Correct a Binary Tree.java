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
    public TreeNode correctBinaryTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<TreeNode> visited = new ArrayList<>();
        visited.add(root);

        TreeNode invalidNode = null;

        while(!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for(int i=0; i<size; i++){
                TreeNode tnode = q.remove();
                if(tnode.left != null){
                    q.add(tnode.left);
                    visited.add(tnode.left);
                }
                if(tnode.right != null){
                    if(visited.contains(tnode.right)){
                        tnode.right = null;
                        invalidNode = tnode;
                        found = true;
                        break;
                    }else{
                        q.add(tnode.right);
                        visited.add(tnode.right);
                    }
                }
            }
            if(found) break;
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for(int i=0; i<size; i++){
                TreeNode tnode = q.remove();
                if(tnode.left != null){
                    if(tnode.left.equals(invalidNode)){
                        tnode.left = null;
                        found = true;
                        break;
                    }else{
                        q.add(tnode.left);
                    }
                }
                if(tnode.right != null){
                    if(tnode.right.equals(invalidNode)){
                        tnode.right = null;
                        found = true;
                        break;
                    }else{
                        q.add(tnode.right);
                    }
                }
            }
            if(found) break;
        }

        return root;
    }
}