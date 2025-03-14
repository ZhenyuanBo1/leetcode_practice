/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> st = new Stack<>();

        while(head != null){
            st.push(head);
            head = head.getNext();
        }

        while(!st.isEmpty()){
            ImmutableListNode node = st.pop();
            node.printValue();
        }
    }
}