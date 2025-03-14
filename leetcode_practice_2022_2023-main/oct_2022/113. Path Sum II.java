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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if(root == null) return res;
        curr.add(root.val);
        helper(res, curr, root, targetSum-root.val);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, TreeNode root, int currSum){
        if(currSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(root.left != null){
            curr.add(root.left.val);
            helper(res, curr, root.left, currSum-root.left.val);
            curr.remove(curr.size()-1);
        }
        if(root.right != null){
            curr.add(root.right.val);
            helper(res, curr, root.right, currSum-root.right.val);
            curr.remove(curr.size()-1);
        }
    }
}