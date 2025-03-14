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
    public ListNode insertionSortList(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            list.add(p.val);
            p = p.next;
        }

        for(int i=1; i<list.size(); i++){
            int curr = list.get(i);
            int j = i-1;

            //move all the values greater than the current to the right
            while(j>=0 && list.get(j) > curr){
                list.set(j+1, list.get(j));
                j--;
            }

            list.set(j+1, curr);
        }

        ListNode dummy = new ListNode();

        p = dummy;

        for(Integer val: list){
            p.next = new ListNode(val);
            p = p.next;
        }

        return dummy.next;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while(curr != null){
            ListNode prev = dummy;

            while(prev.next != null && prev.next.val <= curr.val){
                prev = prev.next;
            }

            ListNode next = curr.next;
            //insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}