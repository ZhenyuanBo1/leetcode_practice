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
class FindElements {
    Queue<TreeNode> q;
    List<Integer> vals;
    public FindElements(TreeNode root) {
        this.q = new LinkedList<>();
        this.vals = new ArrayList<>();
        
        root.val = 0;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                this.vals.add(node.val);
                if(node.left != null){
                    node.left.val = 2 * node.val + 1;
                    q.add(node.left);
                }
                if(node.right != null){
                    node.right.val = 2 * node.val + 2;
                    q.add(node.right);
                }
            }
        }
    }
    
    public boolean find(int target) {
        return this.vals.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */