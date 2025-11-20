# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool: # type: ignore
        
        def dfs(node):
            
            if not node:
                return [True, 0]

            left = dfs(node.left)
            right = dfs(node.right)

            # we'll look at the subtrees heights to see if differences greater than 1
            # and check if each subtree is balanced
            balanced = left[0] and right[0] and abs(left[1] - right[1]) <= 1

            # want to return whether the current nodes subtree is balanced
            # and get the maximum between the left height and right height to get the height ofthe subtree
            return [balanced, max(left[1], right[1]) + 1]

        # get the boolean value
        return dfs(root)[0]

            
        
