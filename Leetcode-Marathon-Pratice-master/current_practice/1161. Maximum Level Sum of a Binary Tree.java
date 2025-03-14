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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeMap<Integer, Integer> summap = new TreeMap<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            summap.put(level, sum);
            level += 1;
        }

        int max = Collections.max(summap.values());
        int ans = -1;

        for(Integer key: summap.keySet()){
            if(summap.get(key) == max){
                ans = key;
                break;
            }
        }

        return ans;
    }
}