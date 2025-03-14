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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stL1 = new Stack<>();
        Stack<Integer> stL2 = new Stack<>();

        while(l1 != null){
            stL1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            stL2.push(l2.val);
            l2 = l2.next;
        }

        List<Integer> list = new ArrayList<>();
        int carry=0;

        while(!stL1.isEmpty() || !stL2.isEmpty()){
            int val=0;
            if(stL1.isEmpty() && !stL2.isEmpty()){
                val = stL2.pop() + carry;
            }else if(!stL1.isEmpty() && stL2.isEmpty()){
                val = stL1.pop() + carry;
            }else{
                val = carry + stL1.pop() + stL2.pop();
            }
            int remainder = val % 10;
            carry = val / 10;
            list.add(0, remainder);
        }
        
        if(carry > 0) list.add(0, carry);

        ListNode head = new ListNode(list.get(0));
        ListNode p = head;

        for(int i=1; i<list.size(); i++){
            ListNode curr = new ListNode(list.get(i));
            p.next = curr;
            p = curr;
        }

        p.next = null;

        return head;
    }
}