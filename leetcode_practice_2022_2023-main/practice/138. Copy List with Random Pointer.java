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
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();

        Node p = head;

        while(p != null){
            Node clone = new Node(p.val);
            cloneMap.put(p, clone);
            p = p.next;
        }

        Node clone = cloneMap.get(head);

        Node p1 = clone;
        p = head;

        while(p != null){
            p1.next = cloneMap.get(p.next);
            p1.random = cloneMap.get(p.random);
            p1 = p1.next;
            p = p.next;
        }

        return clone;
    }
}