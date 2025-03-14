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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        while(curr!=null){
            if(curr.val == val){
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}