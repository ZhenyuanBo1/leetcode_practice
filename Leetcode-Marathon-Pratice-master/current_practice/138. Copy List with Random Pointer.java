/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //create a map that contains old node as the key and new node as the value
    private Map<Node, Node> visited;

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        this.visited = new HashMap<>();

        Node curr = head;
        Node newNode = new Node(curr.val);
        visited.put(curr, newNode);

        Node dummy = new Node(0);
        dummy.next = newNode;

        while(curr != null){
            newNode.next = this.getClonedNode(curr.next);
            newNode.random = this.getClonedNode(curr.random);
            newNode = newNode.next;
            curr = curr.next;
        }

        return dummy.next;

    }

    private Node getClonedNode(Node node){
        if(node != null){
            if(this.visited.containsKey(node)){
                return this.visited.get(node);
            }else{
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }
}

