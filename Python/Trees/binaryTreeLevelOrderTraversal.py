# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from typing import Optional


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]: # type: ignore
        ret = []
        
        if not root:
            return ret
        
        q = deque()
        q.append((root, 0))

        hList = []
        currentHeight = 0

        while q:
            # we want to iterate using bfs
            # then we can add the height to the queue each time to put it into a new list
            node, nodeH = q.popleft()
            
            if nodeH != currentHeight:
                # we want to update currentHeight
                currentHeight += 1
                #we want to append hList to ret
                ret.append(hList)
                #reset hList
                hList = []
            # and we want to add current value to hList
            hList.append(node.val)

            if node.left:
                q.append((node.left, nodeH + 1))
            if node.right:
                q.append((node.right, nodeH + 1))

        if hList:
            ret.append(hList)

        return ret
