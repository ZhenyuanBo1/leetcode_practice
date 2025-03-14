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
class BSTIterator {

    private Stack<Integer> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }
    
    public int next() {
        return st.pop();
    }
    
    public boolean hasNext() {
        if(st.isEmpty()) return false;
        return true;
    }

    private void helper(TreeNode root){
        if(root.right != null){
            helper(root.right);
        }
        st.push(root.val);
        if(root.left != null){
            helper(root.left);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */