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
        ListNode less = new ListNode();
        ListNode greater = new ListNode();

        ListNode pLess = less;
        ListNode pGreater = greater;

        ListNode p = head;

        while(p!=null){
            if(p.val < x){
                pLess.next = p;
                pLess = pLess.next;
            }else{
                pGreater.next = p;
                pGreater = pGreater.next;
            }
            p = p.next;
        }

        ListNode pGreater1 = greater.next;

        pLess.next = pGreater1;

        pGreater.next = null;

        return less.next;


    }
}