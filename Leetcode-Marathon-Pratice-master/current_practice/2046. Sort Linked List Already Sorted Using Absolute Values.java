/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        List<ListNode> negNode = new ArrayList<>();

        while(p1.next != null){
            if(p1.next.val < 0){
                p2 = p1.next;
                p1.next = p2.next;
                p2.next = null;
                negNode.add(p2);
            }else{
                p1 = p1.next;
            }
        }

        if(negNode.size() == 0) return head;

        for(int i=negNode.size()-1; i-1>=0; i--){
            ListNode currNegNode = negNode.get(i);
            currNegNode.next = negNode.get(i-1);
        }

        negNode.get(0).next = dummy.next;

        return negNode.get(negNode.size()-1);
    }
}