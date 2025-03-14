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
        int maxWidth = Integer.MIN_VALUE;
        
        //we need to record each node and the index of it 
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            int currSize = queue.size();
            Pair<TreeNode, Integer> head = queue.getFirst();
            Pair<TreeNode, Integer> elem = null;
            for(int i=0; i<currSize; i++){
                elem = queue.remove();
                TreeNode node = elem.getKey();
                if(node.left != null){
                    queue.add(new Pair<>(node.left, 2*elem.getValue()));
                }
                if(node.right != null){
                    queue.add(new Pair<>(node.right, 2*elem.getValue()+1));
                }
            }

            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;

    }
}