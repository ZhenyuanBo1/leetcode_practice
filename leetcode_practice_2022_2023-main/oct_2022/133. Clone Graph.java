/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


// DFS
class Solution {

    Map<Node, Node> visited = new HashMap<>(); // key is the original node and val is the cloned node
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        if(visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val, new ArrayList<Node>());

        visited.put(node, clonedNode);

        for(Node neighbor: node.neighbors){
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;

    }
}

//BFS
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        Map<Node, Node> visited = new HashMap<>();

        Node clonedNode = new Node(node.val, new ArrayList<>());

        visited.put(node, clonedNode);

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.remove();
            for(Node neighbor: curr.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}