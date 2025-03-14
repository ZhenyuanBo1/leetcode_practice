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
    private PriorityQueue<Integer> pq;
    public BSTIterator(TreeNode root) {
        this.pq = new PriorityQueue<>((p1, p2) -> p1 - p2);
        this.populateQueue(root);
    }
    
    public int next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }

    private void populateQueue(TreeNode root){
        if(root.left != null){
            populateQueue((root.left));
        }
        this.pq.add(root.val);
        if(root.right != null){
            populateQueue(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */