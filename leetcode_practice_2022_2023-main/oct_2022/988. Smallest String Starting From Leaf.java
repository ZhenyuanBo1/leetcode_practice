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

    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        List<String> res = new ArrayList<>();
        String curr = "" + (char)(root.val+97);
        helper(res, curr, root);

        Collections.sort(res);

        return res.get(0);
    }
    private String revertStr(String str){
        String res = "";
        for(int i=str.length()-1; i>=0; i--){
            res += str.charAt(i);
        }
        return res;
    }
    private void helper(List<String> res, String curr, TreeNode root){
        if(root.left == null && root.right == null){
            res.add(revertStr(curr));
            return;
        }

        if(root.left != null){
            helper(res, curr+(char)(root.left.val+97), root.left);
        }
        if(root.right != null){
            helper(res, curr+(char)(root.right.val+97), root.right);
        }
    }
}