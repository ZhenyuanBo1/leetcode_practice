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
        if(root == null) return root;
        
        Map<Node, Node> map = new HashMap<>();
        map.put(root, new ArrayList<>());

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr = queue.remove();
            for(Node child: curr.children){
                if(!map.containsKey(curr)){
                    map.put(curr, new Node(curr.val, new ArrayList<>()));
                    queue.add(curr);
                }
                map.get(curr).children.add(map.get(child));
            }
        }

        return map.get(root);
    }
}