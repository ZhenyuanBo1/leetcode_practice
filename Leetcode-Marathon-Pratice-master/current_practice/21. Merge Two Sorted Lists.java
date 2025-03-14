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
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode newHead = new ListNode();
        ListNode newCurr = newHead;

        while(curr1 != null || curr2 != null){
            if(curr2==null || (curr1 != null && curr1.val < curr2.val)){
                newCurr.next = new ListNode(curr1.val);
                newCurr = newCurr.next;
                curr1 = curr1.next;
            }else{
                newCurr.next = new ListNode(curr2.val);
                newCurr = newCurr.next;
                curr2 = curr2.next;
            }
        }

        return newHead.next;
    }
}

