// O(n) solution very optimal
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // min nodes = 0 and all cases where you are guaranteed you dont have to do anything
        if (head == null || head.next == null || head.next.next == null) 
            return head;

        ListNode evensHead = head.next; 
        head.next = evensHead.next; //removing evensHead from og ll
        evensHead.next = null;

        ListNode evensTail = evensHead; //where we will append other even nodes to
        ListNode tail = head.next; //ptr to iterate through og ll (starts at node 3)
        
        while (tail.next != null && tail.next.next != null) {
            evensTail.next = tail.next; //is node 4
            evensTail = evensTail.next; // setting even tail to last node in list
            tail.next = evensTail.next; // set tail next ptr to the next odd node 
            evensTail.next = null; // removing evensTail from the og list
            tail = tail.next;
        }

        if (tail.next == null) {
            
            // evensTail.next is already null now
        } else { //tail.next.next == null 
            evensTail.next = tail.next;
            evensTail = evensTail.next;
            evensTail.next = null;
        }

        tail.next = evensHead;



        return head;
    }
}