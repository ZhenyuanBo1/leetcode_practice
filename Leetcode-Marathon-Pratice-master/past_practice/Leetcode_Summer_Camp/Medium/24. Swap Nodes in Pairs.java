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
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode prevNP = new ListNode(-1);
        int i=0;

        while(p!=null && p.next!=null){
            ListNode nP = p.next;
            p.next = nP.next;
            nP.next = p;
            if(i==0) head = nP;
            p = p.next;
            prevNP.next = nP;
            prevNP = nP.next;
            i++;
        }

        return head;
    }
}