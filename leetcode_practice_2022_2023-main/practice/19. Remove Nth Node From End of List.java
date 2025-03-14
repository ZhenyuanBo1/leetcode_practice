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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> res = new ArrayList<>();

        while(head!=null){
            res.add(head.val);
            head = head.next;
        }

        int targetIndex = res.size() - n;

        ListNode p = new ListNode();
        ListNode p1 = p;

        for(int i=0; i<res.size(); i++){
            if(i==targetIndex) continue;
            p1.next = new ListNode(res.get(i));
            p1 = p1.next;
        }

        return p.next;
    }
}