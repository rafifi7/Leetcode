# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

# iterative dfs to find a matching root, then run recursive dfs on both to see if they are the same subtree
#

class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool: # type: ignore
        if not root and not subRoot:
            return True
        if not root and subRoot or subRoot and not root:
            return False

        stack = [root]

        def dfs(p, q):
            if not p and not q:
                return True
            if not p and q or not q and p:
                return False
            if p.val != q.val:
                return False
            
            return dfs(p.left, q.left) and dfs(p.right, q.right)

        while stack:
            node = stack.pop()

            if node.val == subRoot.val:
                if dfs(node, subRoot):
                    return True

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return False