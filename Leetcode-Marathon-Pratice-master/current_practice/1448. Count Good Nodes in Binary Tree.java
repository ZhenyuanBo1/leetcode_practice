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

    public int goodNodes(TreeNode root) {
        return 1 + countGoodNodes(root.left, root.val) + countGoodNodes(root.right, root.val);
    }

    private int countGoodNodes(TreeNode root, int maxVal){
        if(root == null) return 0;

        if(root.val >= maxVal){
            return 1 + countGoodNodes(root.left, Math.max(root.val, maxVal)) + countGoodNodes(root.right, Math.max(root.val, maxVal));
        }else{
            return countGoodNodes(root.left, Math.max(root.val, maxVal)) + countGoodNodes(root.right, Math.max(root.val, maxVal));
        }
    }
}

//DFS + Recursive