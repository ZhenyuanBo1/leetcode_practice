class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if(root == null) return res;
        path.add(String.valueOf(root.val));
        helper(res, path, root);
        return res;
    }
    private void helper(List<String> res, List<String> path, TreeNode root){
        if(root.left == null && root.right == null){
            String curr = String.join("->", path);
            res.add(curr);
            return;
        }

        if(root.left != null){
            path.add(String.valueOf(root.left.val));
            helper(res, path, root.left);
            path.remove(path.size()-1);
        }

        if(root.right != null){
            path.add(String.valueOf(root.right.val));
            helper(res, path, root.right);
            path.remove(path.size()-1);
        }
    }
}