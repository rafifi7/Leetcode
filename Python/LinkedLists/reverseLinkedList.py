# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]: # type: ignore
        if not head or not head.next:
            return head
        # if list > 1

        l = None
        m = head
        r = head

        # [ 1, 2, 3, 4, 5]
        # l   m
        #     r
        # make r = m.next
        # l   m  r
        # make m.next point to l
        # make l become m 
        # make m become r


        while m:
            r = m.next
            m.next = l
            l = m
            m = r



        head = l


        return head


