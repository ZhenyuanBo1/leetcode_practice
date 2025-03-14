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
    private List<Integer> list;
    private int pointer;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.pointer = -1;
        helper(root);
    }
    
    public boolean hasNext() {
        if(pointer+1 < list.size()) return true;
        return false;
    }
    
    public int next() {
        int nextVal = list.get(++pointer);
        return nextVal;
    }
    
    public boolean hasPrev() {
        if(pointer-1 >= 0) return true;
        return false;
    }
    
    public int prev() {
        int prevVal = list.get(--pointer);
        return prevVal;
    }

    private void helper(TreeNode root){
        if(root.left != null){
            helper(root.left);
        }
        this.list.add(root.val);
        if(root.right != null){
            helper(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */