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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k==0) return head;

        int count = 0;
        ListNode p = head;

        while(p!=null){
            count += 1;
            p = p.next;
        }


        int pos = count-(k % count);


        int count1 = 0;

        ListNode p1 = head;

        while(count1+1<pos){
            p1 = p1.next;
            count1 += 1;
        }


        ListNode dummy = new ListNode();
        dummy.next = p1.next;

        if(dummy.next == null) return head;

        ListNode p2 = p1.next;
        p1.next = null;

        while(p2!=null && p2.next!=null){
            p2 = p2.next;
        }

        if(p2!=null) p2.next = head;

        return dummy.next;


    }
}