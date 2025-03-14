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
    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            list.add(p.val);
            p = p.next;
        }

        int l = 0, r = list.size()-1;

        p = head;

        while(l<r){
            p.val = list.get(l);
            p.next.val = list.get(r);
            p = p.next.next;
            l++;
            r--;
        }

        if(l==r) p.val = list.get(l);
    }
}