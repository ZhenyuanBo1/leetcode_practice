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
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = head;

        while(curr!=null){
            curr = curr.next;
            count+=1;
        }

        ListNode p = dummy;

        for(int i=0; i<count/2; i++){
            p = p.next;
        }

        ListNode deleteNode = p.next;

        ListNode next = deleteNode.next;

        p.next = next;

        deleteNode.next = null;

        return dummy.next;
    }

}