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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // if(left == right) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = dummy;
        ListNode p0 = null;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;

        int pos = 0;

        while(p!=null){
            if(pos+1 == left){
                p0 = p;
                p1 = p.next;
                p = p.next;
                p0.next = null;
            }else if(pos == right){
                p2 = p;
                p3 = p.next;
                p2.next = null;
                break;
            }else{
                p = p.next;
            }
            pos += 1;
        }

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


        return dummy.next;
    }
}