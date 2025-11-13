class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # base cases
        if not head or k == 1:
            return head

        # fp = fast pointer (used to check next k nodes)
        # sp = slow pointer (used for actual reversal)
        fp = sp = head
        newHead = None      # first reversed group's head becomes newHead
        oldTail = None      # keeps track of the last node of the previous reversed group

        while True:
            # check if there are k nodes to reverse
            count = 0
            temp = fp
            while temp and count < k:
                temp = temp.next
                count += 1

            # if less than k nodes remain, stop reversing
            if count < k:
                if oldTail:
                    oldTail.next = sp  # connect the last reversed group to leftover nodes
                break

            l = None          # left pointer for standard 3-pointer reversal
            tail = sp         # tail will become the end of this reversed group

            # reverse k nodes
            for _ in range(k):
                r = sp.next   # store next
                sp.next = l   # reverse current link
                l = sp        # move left forward
                sp = r        # move slow pointer forward

            # if this is the first reversed group, record its head
            if not newHead:
                newHead = l

            # connect previous group to this new reversed segment
            if oldTail:
                oldTail.next = l

            # update oldTail to this group's tail
            oldTail = tail

            # move fp to the start of the next group
            fp = sp

        # return new head (or original if no reversal happened)
        return newHead if newHead else head
