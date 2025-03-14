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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        //break list into several sublists and then reverse and then link them together
        int group = 1;
        ListNode p = head;

        List<ListNode> heads = new ArrayList<>();
        List<Integer> groupSize = new ArrayList<>();

        while(p!=null){
            heads.add(p);
            int count = 1;

            for(int i=0; i<group-1; i++){
                if(p.next == null) break;
                p = p.next;
                count += 1;
            }

            groupSize.add(count);

            ListNode p2 = p.next;
            p.next = null;
            p = p2;
            group+=1;
        }

        for(int i=0; i<groupSize.size(); i++){
            if(groupSize.get(i) % 2 == 0){
                //reverse list
                ListNode newHead = reverseList(heads.get(i));
                heads.set(i, newHead);
            }
        }

        //link all the heads together
        for(int i=0; i+1<heads.size(); i++){
            ListNode currHead = heads.get(i);
            ListNode currEnd = findEnd(currHead);
            currEnd.next = heads.get(i+1);
        }

        return head;
    }

    private ListNode findEnd(ListNode head){
        ListNode curr = head;
        while(curr.next != null) curr = curr.next;
        return curr;
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode last = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }

        return last;
    }

}