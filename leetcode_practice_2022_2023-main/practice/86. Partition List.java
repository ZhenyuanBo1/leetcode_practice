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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode p1 = dummy;

        ListNode p = head;

        while(p!=null){
            if(p.val < x){
                p1.next = new ListNode(p.val);
                p1 = p1.next;
            }
            p = p.next;
        }

        p = head;

        while(p!=null){
            if(p.val>=x){
                p1.next = new ListNode(p.val);
                p1 = p1.next;
            }
            p = p.next;
        }

        return dummy.next;
    }
}