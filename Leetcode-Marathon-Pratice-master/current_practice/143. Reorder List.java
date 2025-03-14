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
    public void reorderList(ListNode head) {
        //break the linkedlist and reverse the second half
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = head;

        while(curr!=null){
            curr = curr.next;
            count += 1;
        }

        ListNode p = dummy;
        //look for the start of the second half list
        for(int i=0; i<(count+1)/2; i++){
            p = p.next;
        }

        ListNode q = p.next;
        p.next = null;

        ListNode head2 = reverseList(q);

        ListNode p1 = head, p2 = head2;
        ListNode h = dummy;

        while(p1!=null || p2!=null ){
            if(p1!=null){
                h.next = p1;
                p1 = p1.next;
                h = h.next;
            }
            if(p2!=null){
                h.next = p2;
                p2 = p2.next;
                h = h.next;
            }
        }


    }

    private ListNode reverseList(ListNode head){
        ListNode last = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }

        return last;
    }
}