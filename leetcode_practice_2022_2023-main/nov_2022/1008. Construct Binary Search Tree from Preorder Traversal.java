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
    public TreeNode bstFromPreorder(int[] preorder) {
        //get the root node
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        List<Integer> leftTree = new ArrayList<>();

        for(int i=1; i<preorder.length; i++){
            if(preorder[i] < rootVal){
                leftTree.add(preorder[i]);
            }
        }

        int[] leftPreorder = new int[leftTree.size()];

        for(int j=0; j<leftTree.size(); j++){
            leftPreorder[j] = leftTree.get(j);
        }

        int[] rightPreorder = new int[preorder.length - 1 - leftPreorder.length];

        int rightIndex = leftPreorder.length+1;

        int k=0;
        for(int i=rightIndex; i<preorder.length; i++){
            rightPreorder[k++] = preorder[i];
        }

        if(leftPreorder.length > 0){
            root.left = bstFromPreorder(leftPreorder);
        }

        if(rightPreorder.length > 0){
            root.right = bstFromPreorder(rightPreorder);
        }

        return root;
    }
}