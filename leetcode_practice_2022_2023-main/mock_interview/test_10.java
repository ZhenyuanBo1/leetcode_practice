/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        ListNode p = headA;
        
        while(p!=null){
            set.add(p);
            p = p.next;
        }
        
        ListNode p1 = headB;
        
        while(p1 != null){
            if(set.contains(p1)) return p1;
            p1 = p1.next;
        }
        
        return null;
    }
}