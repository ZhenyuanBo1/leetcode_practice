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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
            list.add(p.val);
        }

        ListNode dummy = new ListNode();

        p = dummy;

        for(Integer n: list){
            int freq = map.get(n);
            if(freq == 1){
                p.next = new ListNode(n);
                p = p.next;
            }
        }

        return dummy.next;
    }
}
//solution #2 - two pointers
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}