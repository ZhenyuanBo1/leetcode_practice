/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        List<List<Node>> list = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            List<Node> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node n = q.poll();
                level.add(n);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            list.add(level);
        }

        for(List<Node> nodes: list){
            for(int i=0; i+1<nodes.size(); i++){
                Node curr = nodes.get(i);
                curr.next = nodes.get(i+1);
            }
        }

        return list.get(0).get(0);
    }
}