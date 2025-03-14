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

class Solution {
    private List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root);
        res.add(root.val);
        return res;
    }
    private void dfs(Node root){
        if(root.children.size() == 0) return;
        for(Node node: root.children){
            dfs(node);
            res.add(node.val);
        }
    }
}