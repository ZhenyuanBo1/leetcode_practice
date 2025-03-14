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
        if(node == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Map<Node, Node> map = new HashMap<>();

        List<Node> visited = new ArrayList<>();

        //create cloned copy of each node
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                if(!visited.contains(n)){
                    visited.add(n);
                    Node cloned = new Node(n.val);
                    map.put(n, cloned);

                    List<Node> neighbors = n.neighbors;
                    q.addAll(neighbors);
                }
            }
        }

        //create cloned graph
        q.add(node);
        visited = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                if(!visited.contains(n)){
                    visited.add(n);
                    Node cloned = map.get(n);
                    List<Node> neighbors = n.neighbors;
                    List<Node> newneighbors = new ArrayList<>();
                    for(Node nei: neighbors){
                        newneighbors.add(map.get(nei));
                    }
                    cloned.neighbors = newneighbors;
                    q.addAll(neighbors);
                }
            }
        }

        return map.get(node);

    }
}