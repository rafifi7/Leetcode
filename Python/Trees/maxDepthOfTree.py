# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# O(n) recursive solution
from collections import deque
from typing import Optional


class Solution:

    def maxDepth(self, root: Optional[TreeNode]) -> int: # type: ignore
        
        # can do recursively or iteratively but recursively easier
        if not root:
            return 0

        def findMax(node, height):

            if not node.left and not node.right:
                return height
            
            if node.left and node.right:
                return max(findMax(node.left, height + 1), findMax(node.right, height + 1) )
            elif node.left:
                return findMax(node.left, height + 1)
            else:
                return findMax(node.right, height + 1)

    
        return findMax(root, 1)


# O(n) dfs solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def maxDepth(self, root: Optional[TreeNode]) -> int: # type: ignore

        # dfs O(n) solution
        if not root:
            return 0

        stack = []
        stack.append((root, 1))
        maxHeight = 1
        while stack:
            node, height = stack.pop()
            maxHeight = max(height, maxHeight)

            newHeight = height + 1
            if node.left:
                stack.append((node.left, newHeight))
            if node.right:
                stack.append((node.right, newHeight))

        return maxHeight

# O(n) bfs solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def maxDepth(self, root: Optional[TreeNode]) -> int: # type: ignore

        # dfs O(n) solution
        if not root:
            return 0

        q = deque()
        q.append((root, 1))
        maxHeight = 1
        while q:
            node, height = q.popleft()
            maxHeight = max(height, maxHeight)

            newHeight = height + 1
            if node.left:
                q.append((node.left, newHeight))
            if node.right:
                q.append((node.right, newHeight))

        return maxHeight



        

        


        