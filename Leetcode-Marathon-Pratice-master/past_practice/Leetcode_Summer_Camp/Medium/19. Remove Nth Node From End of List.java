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
        int count=0;

        ListNode p = head;

        while(p!=null){
            p=p.next;
            count++;
        }

        int target = count-n-1;

        int i=0;

        p = head;

        if(target<0) return p.next;

        while(i<target){
            p = p.next;
            i++;
        }

        ListNode np = p.next;

        if(np!=null){
            p.next = np.next;
            np=null;
        }

        return head;
    }
}

//one pass

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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i=1; i<=n+1; i++){
            first = first.next;
        }

        while(first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;

    }
}