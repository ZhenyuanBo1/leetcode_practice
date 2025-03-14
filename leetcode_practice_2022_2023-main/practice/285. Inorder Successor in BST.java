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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        int targetVal = p.val;
        traverse(list, root);

        int i = 0;
        for(TreeNode node: list){
            if(node.val == targetVal){
                if(i == list.size() - 1) return null;
                return list.get(i+1);
            }
            i++;
        }

        return null;
    }
    private void traverse(List<TreeNode>list, TreeNode curr){
        if(curr.left != null){
            traverse(list, curr.left);
        }

        list.add(curr);

        if(curr.right != null){
            traverse(list, curr.right);
        }
    }
}