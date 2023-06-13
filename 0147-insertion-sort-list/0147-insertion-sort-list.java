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
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev, num;
        ListNode dummy = new ListNode(-1, head);
        while(curr!=null && curr.next!=null){
            if(curr.val <= curr.next.val){
                curr = curr.next;
            }
            else{
                num = curr.next;
                prev = dummy;
                while(prev.next.val < num.val){
                    prev = prev.next;
                }
                curr.next = num.next;
                num.next = prev.next;
                prev.next = num;
            }
        }
        return dummy.next;
    }
}