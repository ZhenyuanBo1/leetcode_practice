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
    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<List<Node>> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        list.add(root);
        q.add(list);

        int depth = 0;

        while(!q.isEmpty()){
            List<Node> nodeList = q.remove();
            depth += 1;

            List<Node> newList = new ArrayList<>();
            for(Node n: nodeList){
                for(Node child: n.children){
                    newList.add(child);
                }
            }
            if(newList.size() == 0) break;
            q.add(newList);
        }

        return depth;
    }
}