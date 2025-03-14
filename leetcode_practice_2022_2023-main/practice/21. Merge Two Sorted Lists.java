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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while(p1 != null || p2 != null){
            if(p1 != null && p2 != null && p1.val <= p2.val){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else if(p1 != null && p2 != null && p1.val > p2.val){
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }else if(p1 == null && p2 != null){
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }else if(p2 == null && p1 != null){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            p = p.next;
        }

        return dummy.next;
    }
}