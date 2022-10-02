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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head; //makes a current ptr to the head node
        ListNode prev = null; //prev is the previous ptr to current
        while(curr != null) { 
            ListNode temp = curr.next; //temp to store the next node of current
            curr.next = prev; //next ptr is 
            prev = curr;
            curr = temp;
        } 
        return prev;
    }
}
