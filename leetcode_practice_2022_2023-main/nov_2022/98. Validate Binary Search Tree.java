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
    public boolean isValidBST(TreeNode root) {
        //using in-order to flatten it into ordered list and check if it is mono-increasing array
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        for(int i=0; i<list.size(); i++){
            if(i+1<list.size() && list.get(i)<list.get(i+1)) continue;
            if(i+1<list.size()) return false;
        }
        return true;
    }
    
    private void helper(List<Integer> list, TreeNode root){
        if(root.left != null){
            helper(list, root.left);
        }
        list.add(root.val);
        if(root.right != null){
            helper(list, root.right);
        }
    }   
}