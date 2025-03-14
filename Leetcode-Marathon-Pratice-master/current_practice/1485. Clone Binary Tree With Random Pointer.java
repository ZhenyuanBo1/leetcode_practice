/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;

        Map<Node, NodeCopy> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                NodeCopy cloned = new NodeCopy(n.val);
                map.put(n, cloned);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node n = q.remove();
                NodeCopy cloned = map.get(n);
                if(n.left != null){
                    cloned.left = map.get(n.left);
                    q.add(n.left);
                }
                if(n.right != null){
                    cloned.right = map.get(n.right);
                    q.add(n.right);
                }
                if(n.random != null) cloned.random = map.get(n.random);
            }
        }

        return map.get(root);
    }
}

//using DFS - Stack

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;

        Map<Node, NodeCopy> map = new HashMap<>();

        Stack<Node> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            Node n = s.pop();
            NodeCopy cloned = new NodeCopy(n.val);
            map.put(n, cloned);
            if(n.left != null) s.push(n.left);
            if(n.right != null) s.push(n.right);
        }

        s.add(root);

        while(!s.isEmpty()){
            Node n = s.pop();
            NodeCopy cloned = map.get(n);
            if(n.left != null){
                cloned.left = map.get(n.left);
                s.push(n.left);
            }
            if(n.right != null){
                cloned.right = map.get(n.right);
                s.push(n.right);
            }
            if(n.random != null){
                cloned.random = map.get(n.random)
            }
        }

        return map.get(root);
    }
}