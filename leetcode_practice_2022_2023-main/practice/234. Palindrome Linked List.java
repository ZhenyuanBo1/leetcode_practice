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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode p = head;

        while(p!=null){
            list.add(p.val);
            p = p.next;
        }

        System.out.println(list);

        int left = 0, right = list.size()-1;

        while(left < right){
            if(list.get(left++) != list.get(right--)) return false;
        }

        return true;
    }
}