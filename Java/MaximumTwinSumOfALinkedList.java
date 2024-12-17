//O(n) optimal solution  reverse half using normal ptr and speed ptr,
// cut into two, then iterate through both
class Solution {
    public int pairSum(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val; // if size is 2
        int maxSum = 0; // all vals guaranteed to be at least 1


        ListNode fast = head.next;
        
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;


        // reversing until we reach half way point
        while (fast.next != null && fast.next.next != null) {
            mid.next = left;
            left = mid;
            mid = right;

            fast = fast.next.next;
            right = right.next;
        }
        mid.next = left;


        // mid and right are now heads of the split lls
        // mid starting from end of first half going backwards
        // right starting at second half going forwards
        while (mid != null && right != null) {
            maxSum = Math.max(maxSum, mid.val + right.val);
            mid = mid.next;
            right = right.next;
        }


        return maxSum;


    }
}