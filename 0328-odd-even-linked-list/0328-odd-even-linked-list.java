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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = null;
        ListNode curr = head;
        int index = 1;
        while(curr != null){
            if(index%2 == 0){
                if(even == null){
                    evenHead = curr;
                    even = curr;
                } 
                else{
                    even.next = curr;
                    even = even.next;
                }
            } 
            else{
                if(odd == null){
                    odd = curr;
                } 
                else{
                    odd.next = curr;
                    odd = odd.next;
                }
            }
            index++;
            curr = curr.next;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}