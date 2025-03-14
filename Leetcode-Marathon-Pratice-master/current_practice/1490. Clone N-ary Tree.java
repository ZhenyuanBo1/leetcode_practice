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
    public Node cloneTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                Node cloned = new Node(n.val);
                map.put(n, cloned);

                List<Node> children = n.children;
                q.addAll(children);
            }
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                Node cloned = map.get(n);
                List<Node> children = n.children;
                List<Node> newChildren = new ArrayList<>();
                for(Node child: children){
                    newChildren.add(map.get(child));
                }
                q.addAll(children);
                cloned.children = newChildren;
            }
        }

        return map.get(root);
    }
}