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
 /*
 preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preorderIndex;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        preorderIndex = 0;
        return arrayToTree(preorder, 0, postorder.length-1);
    }
    
    TreeNode arrayToTree(int preorder[],int left,int right){
        
        if(left>right){
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[preorderIndex++]);
        
        if(left==right){
            return root;
        }
        
       int mid=map.get(preorder[preorderIndex]);
        
       root.left= arrayToTree(preorder,left,mid);
       root.right= arrayToTree(preorder,mid+1,right-1);
        
       return root;
    }
}