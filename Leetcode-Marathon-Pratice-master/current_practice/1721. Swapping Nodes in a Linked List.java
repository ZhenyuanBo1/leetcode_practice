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
 //swap nodes only swap value
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = dummy;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        while(p1!=null){
            if(p1.next != null){
                count1 += 1;
                p1 = p1.next;
            }
            if(count1 == k) break;
        }

        while(p2!=null){
            if(p2.next !=null ){
                count2 += 1;
            }
            p2 = p2.next;
        }

        int k2 = count2-k+1;

        ListNode pEnd = dummy;

        while(pEnd!=null){
            if(pEnd.next != null){
               count3 += 1;
               pEnd = pEnd.next;
            }
            if(count3 == k2) break;
        }

        int temp = p1.val;
        p1.val = pEnd.val;
        pEnd.val = temp;

        return dummy.next;

    }
}