# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]: # type: ignore
        
        summ = None
        nxt = None
        remain = False

        while l1 and l2:
            currSum = l1.val + l2.val
            if remain:
                currSum += 1
            # subtract 10 and add remainder to next
            if currSum >= 10:
                remain = True
                currSum -= 10
            else:
                remain = False
            
            if not summ:
                summ = ListNode(currSum) # type: ignore
                nxt = summ
            else:
                nxt.next = ListNode(currSum) # type: ignore
                nxt = nxt.next
            
            l1 = l1.next
            l2 = l2.next
        

        # now we just add the rest of l1 or l2 to the thing
        if not remain:
            if l1:
                nxt.next = l1
            if l2:
                nxt.next = l2
        else: 
            # if there is a remain at the end we have to add one to each
            while l1 and remain:
                if l1.val == 9:
                    l1.val = 0
                    remain = True
                    nxt.next = ListNode(l1.val) # type: ignore
                    nxt = nxt.next
                    l1 = l1.next
                else: # its less than 9
                    l1.val += 1
                    remain = False
                    nxt.next = l1
            
            while l2 and remain:
                if l2.val == 9:
                    l2.val = 0
                    remain = True
                    nxt.next = ListNode(l2.val) # type: ignore
                    nxt = nxt.next
                    l2 = l2.next
                else: # its less than 9
                    l2.val += 1
                    remain = False
                    nxt.next = l2
        # if remainder still exists after adding the entire list we need to add it
        if remain:
            nxt.next = ListNode(1) # type: ignore

        return summ
                    
                    



            