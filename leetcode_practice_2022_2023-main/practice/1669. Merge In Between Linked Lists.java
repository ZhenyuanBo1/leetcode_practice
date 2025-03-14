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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null;
        ListNode curr = list1;
        int i = 0;

        while(i<a){
            prev = curr;
            curr = curr.next;
            i++;
        }

        while(i<b){
            curr = curr.next;
            i++;
        }

        ListNode prev2 = curr;
        curr = curr.next;

        prev.next = null;
        prev2.next = null;

        ListNode curr1 = list2;

        while(curr1.next != null){
            curr1 = curr1.next;
        }

        curr1.next = curr;

        prev.next = list2;

        return list1;
    }
}