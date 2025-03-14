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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode p = head;

        while(p != null){
            count++;
            p = p.next;
        }

        int mid = count / 2 + 1;

        p = head;

        int i=0;

        while(p!=null){
            i++;
            if(i + 1 == mid){
                ListNode prev = p;
                p = p.next;
                prev.next = null;
                return p;
            }
            p = p.next;
        }

        return null;
    }
}