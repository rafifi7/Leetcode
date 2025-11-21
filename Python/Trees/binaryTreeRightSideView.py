# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from typing import Optional


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]: # type: ignore
        ret = []

        if not root:
            return ret

        # run bfs but do last one in q
        q = deque()
        q.append(root)


        while q:
            # this is the current size of the level
            qLen = len(q)
            for i in range(qLen):
                node = q.popleft()
                if i == qLen - 1:
                    ret.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
        return ret
