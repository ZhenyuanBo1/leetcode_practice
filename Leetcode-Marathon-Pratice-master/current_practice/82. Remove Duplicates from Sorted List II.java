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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = head;
        ListNode prev = dummy;

        while(p!=null){
            if(p.next!= null && p.val == p.next.val){
                ListNode p1 = p;
                while(p1.next!= null && p1.val == p1.next.val){
                    p1 = p1.next;
                }
                ListNode nxt = p1.next;
                prev.next = nxt;
                p1.next = null;
                p = nxt;
            }else{
                prev = p;
                p = p.next;
            }
        }

        return dummy.next;


    }
}