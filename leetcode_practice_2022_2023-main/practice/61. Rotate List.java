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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            list.add(p.val);
            p = p.next;
        }

        int shift = list.size() < k ? k % list.size() : k;

        List<Integer> shiftedList = new ArrayList<>();

        for(int i=list.size()-shift; i<list.size(); i++){
            shiftedList.add(list.get(i));
        }

        for(int j=0; j<list.size()-shift; j++){
            shiftedList.add(list.get(j));
        }

        ListNode newHead = new ListNode(shiftedList.get(0));

        ListNode p1 = newHead;

        for(int m=1; m<shiftedList.size(); m++){
            p1.next = new ListNode(shiftedList.get(m));
            p1 = p1.next;
        }

        return newHead;

    }
}