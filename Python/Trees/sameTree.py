# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool: # type: ignore
        # i will create two stacks one for p and one for q
        if not p and not q:
            return True
        if not p and q or not q and p:
            return False
            
        pStack = []
        qStack = []
        pStack.append(p)
        qStack.append(q)

        while pStack and qStack:
            pNode = pStack.pop()
            qNode = qStack.pop()

            if pNode.val != qNode.val:
                return False

            if pNode.left and not qNode.left or qNode.left and not pNode.left:
                return False
            if pNode.right and not qNode.right or qNode.right and not pNode.right:
                return False
            
            if pNode.left and qNode.left:
                pStack.append(pNode.left)
                qStack.append(qNode.left)

            if pNode.right and qNode.right:
                pStack.append(pNode.right)
                qStack.append(qNode.right)




        if pStack or qStack:
            return False
        return True