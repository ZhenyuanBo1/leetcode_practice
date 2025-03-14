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
    public int pairSum(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode headCopy = head;

        while(head != null){
            st.push(head);
            head = head.next;
        }

        int half = st.size()/2;

        int i=0;

        int max = Integer.MIN_VALUE;

        while(i<half){
            int currSum = headCopy.val + st.pop().val;
            max = Math.max(max, currSum);
            headCopy = headCopy.next;
            i++; 
        }

        return max;
    }
}