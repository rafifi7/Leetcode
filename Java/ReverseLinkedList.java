class Solution {
    public ListNode reverseList(ListNode head) {
        //base case for if linked list is smaller than 3 nodes
        if (head == null || head.next == null) return head;

        if (head.next.next == null) {
            //swap
            ListNode second = head.next;

            second.next = head;
            head.next = null;

            return second;
        }

        //three pointer technique

        ListNode left = null;
        ListNode mid = head;
        ListNode right = mid.next;

        while (mid.next != null) {
            mid.next = left; 

            left = mid;
            mid = right;
            right = right.next;
        }
        mid.next = left;

        return mid;
    }
}