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
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre = new ListNode(-11);
        ListNode sorted = new ListNode(head.val);
        pre.next = sorted;
        head = head.next;
        while(head != null) {
            if(head.val < sorted.val) {
                ListNode tempPre = pre;
                while(pre.next!=null && pre.next.val<head.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                pre.next = new ListNode(head.val);
                pre.next.next = temp;
                pre = tempPre;
            } 
            else {
                sorted.next = new ListNode(head.val);
                sorted = sorted.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}