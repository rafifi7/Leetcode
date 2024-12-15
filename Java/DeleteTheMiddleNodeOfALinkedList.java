// i smurfed it no cap O(n/2)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // double pointer technique 
        if (head.next == null) {
            return null;
        }

        ListNode tail = head;
        ListNode middle = head;

        while (tail.next != null) {
            tail = tail.next;
            if (tail.next == null) 
                break;
            tail = tail.next;
            if (tail.next == null) 
                break;
            middle = middle.next;
        }

        // middle is now one before it needs to be
        // and tail is at the end
        ListNode middy = middle.next;
        middle.next = middy.next;
        return head;
    }
}