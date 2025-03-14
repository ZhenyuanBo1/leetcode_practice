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
    public int[] nextLargerNodes(ListNode head) {
        //we just need to mainain a descending order monotonic stack
        Stack<List<Integer>> st = new Stack<>();

        ListNode curr = head;
        int count = 0;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        int[] ans = new int[count];

        curr = head;
        int i=0;

        while(curr != null){
            int val = curr.val;
            if(st.isEmpty() || st.peek().get(0) > val){
                st.push(Arrays.asList(val, i));
                i++;
            }else{
                while(!st.isEmpty() && st.peek().get(0) < val){
                    int pos = st.peek().get(1);
                    ans[pos] = val;
                    st.pop();
                }
                st.push(Arrays.asList(val, i));
                ans[i] = 0;
                i++;
            }
            curr = curr.next;
        }

        return ans;

    }
}