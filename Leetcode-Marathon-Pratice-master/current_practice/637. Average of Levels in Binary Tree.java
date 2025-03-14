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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        q.add(nodes);

        while(!q.isEmpty()){
            List<TreeNode> currnodes = q.remove();
            int sum = 0, size = currnode.size();

            List<TreeNode> newNodes = new ArrayList<>();
            for(TreeNode node: currnodes){
                sum += node.val;
                if(node.left != null){
                    newNode.add(node.left);
                }
                if(node.right != null){
                    newNode.add(node.right);
                }
            }

            ans.add(sum/size);
            if(newNode.size() == 0) break;
            q.add(newNodes);
        }

        return ans;


    }
}