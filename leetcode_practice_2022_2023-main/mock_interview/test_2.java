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
    private List<Integer> nodes;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        buildInOrderTraverse(root);
        for(int i=0; i<nodes.size(); i++){
            if(p.val == nodes.get(i) && i+1 < nodes.size()){
                return new TreeNode(nodes.get(i+1));
            }
        }

        return null;
    }
    private List<Integer> buildInOrderTraverse(TreeNode root){
        if(root.left != null){
            buildInOrderTraverse(root.left);
        }
        nodes.add(root.val);
        if(root.right != null){
            buildInOrderTraverse(root.right);
        }
    }
}