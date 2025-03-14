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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode getMid(ListNode node){
        // ListNode p = node;
        // ListNode prev = null;

        // while(p != null && p.next != null){
        //     prev = prev == null ? node : prev.next;
        //     p = p.next.next;
        // }

        // ListNode mid = prev.next;
        // prev.next = null;
        // return mid;
        int count = 0;
        ListNode p = node;

        while(p != null){
            count++;
            p = p.next;
        }

        int mid = count / 2 + 1;

        p = node;

        int i=0;

        while(p!=null){
            i++;
            if(i + 1 == mid){
                ListNode prev = p;
                p = p.next;
                prev.next = null;
                return p;
            }
            p = p.next;
        }

        return null;
    }

    private ListNode merge(ListNode node1, ListNode node2){
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null){
            p.next = p1;
        }else{
            p.next = p2;
        }

        return dummy.next;
    }
}