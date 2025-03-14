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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int sum = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                if(node.val >= low && node.val <= high){
                    sum += node.val;
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }

        return sum;
    }
}

//using DFS
// class Solution {
//     private int sum;

//     public int rangeSumBST(TreeNode root, int low, int high) {
//         this.sum = 0;
//         dfs(root, low, high);
//         return sum;
//     }

//     private void dfs(TreeNode root, int l, int h){
//         if(root == null) return;

//         if(root.val >= l && root.val <= h){
//             this.sum += root.val;
//         }
//         //using post-order traversal
//         if(root.val > l) dfs(root.left, l, h);
//         if(root.val < h) dfs(root.right, l, h);
//     }
// }