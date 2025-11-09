# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]: # type: ignore
        length = 1

        fast = head

        while fast and fast.next:
            fast = fast.next.next
            if fast:
                length += 1
            length += 1

        
        # so we have our length reaching the entirety of ll
        # we have our half var reaching half
        # to find nth from end we have to subtract length from k
        # ex: length of list is 5 but n = 3
        # do 5 - 3 and remove the second element 

        if n == length:
            return head.next

        i = length - n - 1
        curr = head
        for _ in range(i):
            curr = curr.next

        # check if there is a node after curr
        # if there is you have to 
        if not curr.next:
            return None

        # remove this node
        tmp = curr.next.next
        curr.next = tmp
        


        return head