# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None: # type: ignore
        """
        Do not return anything, modify head in-place instead.
        """
        # idea now is to do one pass with a fast ptr and slow ptr
        # and reverse the list after the middle point, meaning that once the fast ptr finds the end, we
        # can start reversing at the slow ptr
        # then we can set a tail ptr to the last node in the list, then we can iterate through each and merge

        f = head
        s = head
        #find mid point 
        while f and f.next:
            f = f.next.next
            s = s.next

        # disconnect slow ptr from first list 
        l = None
        temp = s.next
        s.next = None
        s = temp
        # reverse second half
        while s:     
            r = s.next
            s.next = l
            l = s
            s = r

        
        first, second = head, l  
        while second:
            temp_head = first.next
            temp_tail = second.next

            first.next = second
            second.next = temp_head

            first = temp_head
            second = temp_tail






            

