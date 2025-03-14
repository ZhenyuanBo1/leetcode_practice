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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = head;

        Map<Integer, Integer> freqMap = new HashMap<>();

        while(p!=null){
            freqMap.put(p.val, freqMap.getOrDefault(p.val, 0)+1);
            p = p.next;
        }

        ListNode p1 = dummy, p2 = head;

        while(p2!=null){
            if(freqMap.get(p2.val)>1){
                p1.next = p2.next;
                p2.next = null;
                p2 = p1.next;
            }else{
                p2 = p2.next;
                p1 = p1.next;
            }
        }

        return dummy.next;
    }
}