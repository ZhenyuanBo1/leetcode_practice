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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] arr = new int[right-left+1];

        ListNode p = head;

        int pos = 0, i = 0;

        while(p!=null){
            if(pos+1 >= left && pos+1<=right){
                arr[i++] = p.val;
            }
            p = p.next;
            pos++;
        }

        int l = 0, r = arr.length-1;

        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        p = head;

        pos = 0;
        i = 0;

        while(p!=null){
            if(pos+1 >= left && pos+1<=right){
                p.val = arr[i++];
            }
            p = p.next;
            pos++;
        }

        return head;
    }
}



class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) return null;

        ListNode curr = head, prev = null;

        //position where the curr and prev is

        int m = left, n = right;

        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode p = prev, tail = curr;

        while(n > 0){
            ListNode third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        if(p != null){
            p.next = prev;
        }else{
            head = prev;
        }

        tail.next = curr;


        return head;

    }
}