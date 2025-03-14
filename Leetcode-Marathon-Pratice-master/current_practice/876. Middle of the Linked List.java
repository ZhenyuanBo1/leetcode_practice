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
        ListNode curr = head;
        int countNode = 0;

        while(curr != null){
            curr = curr.next;
            countNode += 1;
        }

        int target = countNode/2;

        curr = head;
        for(int i=0; i<target; i++){
            curr = curr.next;
        }


        return curr;

    }
}