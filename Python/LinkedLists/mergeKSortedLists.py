# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]: # type: ignore
        # idea is to have hashmap that maps a number to the first pointer in the ll with that number
        # our hashmap would look like { 1: Node(1), 4: Node(4)}
        # 1 -> 4 -> 5

        # so its either store a pointer to the head of each list that has a unique number
        # kind of like bucketsort so we have the head of each number in our dict
        # then we sort by the keys and make it one big list
        # n being the number of nodes in the lists and m being the number of unique values in the list
        # this would be O(n) to add to dict + O(mlog(m)) to sort keys of dict + O(n) keys to add to list


        #other option is to get the first list with nodes in it to be our base list and as we iterate through 
        # each subsequent list, we check if the num of the node exists in our dict
        # if the num does exist, its a O(1) insertion 
        # if the num does not exist, it will take O(n) time to insert  
        # O(1) to get first list + O(n) to iterate * (O(1) + O(n)) to insert into list if val seen vs not seen

        # either O(mlogm) or O(n^2) in worst case for both so ill take option 1


        if not len(lists) or len(lists) == 1 and not lists[0]:
            return None

        #our dict that holds the first pointer of that value
        numToNode = {}
        
        for curr in lists:
            while curr:
                # we have a head pointer to come back to once we move head into the bucket
                nextHead = curr.next
                if curr.val in numToNode:
                    #insert as next pointer of numToNode[head.val]

                    #first ptr of list
                    # 1 -> 3
                    # temp is now 3 but we want to add 2
                    temp = numToNode[curr.val].next
                    
                    # 1 -> 2
                    numToNode[curr.val].next = curr
                    # 2 -> 3
                    curr.next = temp
                else: 
                    # fix pointer of curr to be the new head of bucket 
                    curr.next = None
                    numToNode[curr.val] = curr

                curr = nextHead

        dummyNode = ListNode(None) # type: ignore

        # for loop through sorted keys
        head = dummyNode
        for key in sorted(numToNode.keys()):
            head.next = numToNode[key]
            # get to last non null node
            while head.next:
                head = head.next



        return dummyNode.next
        

        