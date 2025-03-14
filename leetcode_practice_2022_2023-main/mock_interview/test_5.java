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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        //using BFS
        LinkedList<Pair<TreeNode, Integer>> q = new LinkedList<>(); 
        //for each pair, it contains treenode and the index of the node in each level


        q.offer(new Pair<>(root, 0));

        int maxWidth = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            Pair<TreeNode, Integer> head = q.getFirst();
            Pair<TreeNode, Integer> p = null;
            for(int i=0; i<size; i++){
                p = q.poll();
                TreeNode node = p.getKey();
                if(node.left != null){
                    q.offer(new Pair<>(node.left, 2*p.getValue()));
                }
                if(node.right != null){
                    q.offer(new Pair<>(node.right, 2*p.getValue()+1));
                }
            }
            maxWidth = Math.max(maxWidth, p.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }
}