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
        ListNode p = head;

        while(p!=null){
            if(p.next != null && p.next.val == p.val){
                ListNode p1 = p.next;
                while(p1.next != null && p1.val == p1.next.val){
                    p1 = p1.next;
                }
                ListNode p2 = p1.next;
                p1.next = null;
                p.next = p2;
            }else{
                p = p.next;
            }
        }

        return head;
    }
}