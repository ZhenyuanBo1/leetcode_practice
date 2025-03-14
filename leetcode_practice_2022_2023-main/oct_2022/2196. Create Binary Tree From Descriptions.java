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
    Map<Integer, TreeNode> nodemap = new HashMap<>();
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childNodes = new HashSet<>();
        for(int i=0; i<descriptions.length; i++){
            int rootVal = descriptions[i][0];
            childNodes.add(descriptions[i][1]);
            TreeNode root;

            if(nodemap.containsKey(rootVal)){
                root = nodemap.get(rootVal);
            }else{
                root = new TreeNode(rootVal);
                nodemap.put(rootVal, root);
            }

            if(!nodemap.containsKey(descriptions[i][1])){
                nodemap.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            }

            if(descriptions[i][2] == 1){
                root.left = nodemap.get(descriptions[i][1]);
            }else{
                root.right = nodemap.get(descriptions[i][1]);
            }
        }
        int root = -1;
        for(int j=0; j<descriptions.length; j++){
            if(!childNodes.contains(descriptions[j][0])){
                root = descriptions[j][0];
                break;
            }
        }

        return nodemap.get(root);
    }
}