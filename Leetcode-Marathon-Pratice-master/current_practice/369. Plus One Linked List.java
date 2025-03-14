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
    public ListNode plusOne(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            list.add(p.val);
            p = p.next;
        }

        int prev = 0;

        for(int i=list.size()-1; i>=0; i--){
            int val = list.get(i);
            if(i == list.size()-1){
                val = val + 1;
            }else{
                val = prev + val;
            }
            prev = val/10;
            val = val%10;
            list.set(i, val);
        }

        if(prev != 0) list.add(0, prev);

        ListNode dummy = new ListNode();
        ListNode p1 = dummy;

        for(int i=0; i<list.size(); i++){
            p1.next = new ListNode(list.get(i));
            p1 = p1.next;
        }

        return dummy.next;
    }
}