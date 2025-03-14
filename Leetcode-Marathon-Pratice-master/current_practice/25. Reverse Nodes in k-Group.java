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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p0 = dummy;
        ListNode p1 = null;
        ListNode p2 = dummy;
        ListNode p3 = null;

        int count = 0;

        while(p2!= null && p2.next!=null){
            p2 = p2.next;
            count+=1;
            if(count==k){
                p3 = p2.next;
                p2.next = null;
                p1 = p0.next;
                p0.next = null;

                ListNode curr = p1;
                ListNode last = null;
                ListNode next;
                while(curr != null){
                    next = curr.next;
                    curr.next = last;
                    last = curr;
                    curr = next;
                }

                p0.next = p2;
                p1.next = p3;
                p0 = p1;
                p2 = p3;
                count = 1;
            }
        }

        return dummy.next;

    }
}