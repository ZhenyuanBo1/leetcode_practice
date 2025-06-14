/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


class Solution {
    public Node findRoot(List<Node> tree) {
        Map<Node, Boolean> map = new HashMap<>();
        for(Node node: tree){
            for(Node child: node.children){
                map.put(child, true);
            }
        }

        Node root = null;
        for(Node node: tree){
            if(!map.containsKey(node)) root = node;
        }

        return root;
    }
}