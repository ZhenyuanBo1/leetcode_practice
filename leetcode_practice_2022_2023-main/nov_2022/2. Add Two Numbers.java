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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        while(l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        
        Collections.reverse(list1);

        while(l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        
        Collections.reverse(list2);

        int i = list1.size()-1, j = list2.size()-1;

        int carry = 0;
        while(i>=0 && j>=0){
            int val1 = list1.get(i);
            int val2 = list2.get(j);
            int newVal = val1 + val2 + carry;
            carry = newVal / 10;
            newVal = newVal % 10;
            list3.add(newVal);
            i--;
            j--;
        }

        while(i<0 && j>=0){
            int val = list2.get(j) + carry;
            carry = val / 10;
            val = val % 10;
            list3.add(val);
            j--;
        }

        while(j<0 && i>=0){
            int val = list1.get(i) + carry;
            carry = val / 10;
            val = val % 10;
            list3.add(val);
            i--;
        }
        
        if(carry > 0) list3.add(carry);

        ListNode head = new ListNode(list3.get(0));
        ListNode headCopy = head;

        for(int k=1; k<list3.size(); k++){
            headCopy.next = new ListNode(list3.get(k));
            headCopy = headCopy.next;
        }

        return head;
    }
}