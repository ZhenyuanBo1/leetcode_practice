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
 //my solution
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> sumList = new ArrayList<Integer>();
        
        //populate list1
        while(l1!=null){
            list1.add(0, l1.val);
            l1 = l1.next;
        }
        
        //populate list2
        while(l2!=null){
            list2.add(0, l2.val);
            l2 = l2.next;
        }
        
        int sizeDiff = Math.abs(list1.size()-list2.size());
        int padding=0;
        
        if(list1.size()<list2.size()){
            while(padding<sizeDiff){
                list1.add(0, 0);
                padding++;
            }
        }else if(list1.size()>list2.size()){
            while(padding<sizeDiff){
                list2.add(0, 0);
                padding++;
            }
        }
        
        int carry=0;
        for(int i=list1.size()-1; i>=0; i--){
            int sum = list1.get(i) + list2.get(i) + carry;
            sumList.add(sum%10);
            carry = sum/10;
        }
        
        if(carry!=0){
            sumList.add(carry);
        }
        
        ListNode head = new ListNode(sumList.get(0));
        ListNode headCopy = head;
        
        for(int i=1; i<sumList.size(); i++){
            int val = sumList.get(i);
            headCopy.next = new ListNode(sumList.get(i));
            headCopy = headCopy.next;
        }
        
        return head;
        
    }
}

//suggested solution
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

/*
Complexity Analysis

Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.

Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
*/