/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
*/

class Solution {
    private List<Integer> res; 
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        if(root == null) return res;
        
        res.add(root.val);
        dfs(root);
        return res;
    }
    private void dfs(Node root){
        if(root.children.size() == 0) return;
        for(Node node: root.children){
            res.add(node.val);
            dfs(node);
        }
    }
}