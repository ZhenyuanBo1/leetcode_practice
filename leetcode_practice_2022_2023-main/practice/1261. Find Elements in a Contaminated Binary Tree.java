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

    //using preorder traversal

    private TreeNode root;

    public FindElements(TreeNode root) {
        if(root.val == -1){
            root.val = 0;
        }
        this.root = root;
        recoverTree(this.root);
    }
    
    public boolean find(int target) {
        return findHelper(target, this.root);
    }

    private boolean findHelper(int target, TreeNode root){
        if(root.val == target) return true;
        if(root.left != null){
            if(findHelper(target, root.left)) return true;
        }
        if(root.right != null){
            if(findHelper(target, root.right)) return true;
        }
        return false;
    }

    private void recoverTree(TreeNode root){
        if(root.left != null){
            if(root.left.val == -1) root.left.val = root.val * 2 + 1;
            recoverTree(root.left);
        }
        if(root.right != null){
            if(root.right.val == -1) root.right.val = root.val * 2 + 2;
            recoverTree(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */