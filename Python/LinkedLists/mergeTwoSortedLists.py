# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 and not list2:
            return list1
        if not list1 and list2:
            return list2
        if not list2 and list:
            return list1


        # pick one list to do splicing on



        # so first lets find the lower minimum which will be our list1
        head = None
        if list1.val > list2.val:
            head = list2
            l = list2

            l2 = list1
        else:   
            head = list1
            l = list1

            l2 = list2


        # l 1 = 1 2 4

        # l 2 = 1 3 4 

        # l = 1 -> 2 -> 4
        # l2 = 1 -> 3-> 4 
        # r = 2 and r2 = 3

        # l = 1 -> 1 -> 2 -> 4
        # l2 = 3-> 4 
        # r = 2 r2 = 3

        # l = 1 -> 1 -> 2 -> 4
        # l2 = 3-> 4 
        # r = 4 r2 = 3

        # l = 1 -> 1 -> 2 -> 3 -> 4
        # l2 = 4




        while l.next and l2:
            r = l.next
            r2 = l2.next

            # we want to set the l.next to the smaller of the two
            
            # getting the minimum next value because we want it to be sorted
            if l.next.val <= l2.val:
                l = l.next
            else: # l.next > l2
                # because 1 2 4
                #         3 5
                # becomes 1 2 3        4
                # splicing happens here
                l.next = l2
                l2.next = r
                # reset pointers
                l = l2
                l2 = r2

    

        # because l2 may have been used up we don't have to do anything because l is now correctly sorted
        # but it l was used up we need to attach the rest of l2 onto l
        if l2:
            l.next = l2

        

        return head



