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
    // private int totalSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    private int dfs(TreeNode root, int totalSum){
        if(root == null) return 0;
        
        totalSum += dfs(root.right);
        int rootVal = root.val;
        rootVal += totalSum;
        totalSum = rootVal;
        System.out.println("root val: " + root.val + " sum val: " + totalSum);
        dfs(root.left);
        System.out.println("total sum: " + totalSum);
        root.val = totalSum;
        return totalSum;
    }
}
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        
        while(!st.isEmpty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.right;
            }
            
            curr = st.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        
        return root;
    }

}