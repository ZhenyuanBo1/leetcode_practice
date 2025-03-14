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
    //using inorder traversal
    private List<Integer> list;
    private Map<Integer, Integer> map = new HashMap<>();
    public void recoverTree(TreeNode root) {
        this.list = new ArrayList<>();
        buildTraversal(root);
        System.out.println(this.list);

        List<Integer> listCopy = new ArrayList<>(this.list);

        Collections.sort(listCopy);

        for(int i=0; i<list.size(); i++){
            if(listCopy.get(i) != list.get(i)){
                map.put(list.get(i), listCopy.get(i));
            }
        }

        rebuildTree(root);

    }
    private void buildTraversal(TreeNode root){
        if(root.left != null){
            buildTraversal(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            buildTraversal(root.right);
        }
    }

    private void rebuildTree(TreeNode root){
        if(map.containsKey(root.val)){
            root.val = map.get(root.val);
        }
        if(root.left != null){
            rebuildTree(root.left);
        }
        if(root.right != null){
            rebuildTree(root.right);
        }
    }
}

public class Solution {
    public void recoverTree(TreeNode root) {
        //using morris traversal
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        boolean firstTime = true;

        while(root != null){
            if(root.left != null){
                TreeNode node = root.left;
                while(node.right != null && node.right != root){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = root;
                    root = root.left;
                }else{
                    node.right = null;
                    if(prev.val > root.val && firstTime){
                        first = prev;
                        firstTime = false;
                    }
                    if(prev.val > root.val && !firstTime){
                        second = root;
                    }
                    prev = root;
                    //visit
                    root = root.right;
                }
            }else{
                //this is the part that will visit the root 
                if(prev.val > root.val && firstTime){
                    first = prev;
                    firstTime = false;
                }
                if(prev.val > root.val && !firstTime){
                    second = root;
                }
                prev = root;
                root = root.right;
            }
        }

        if(first != null && second != null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
