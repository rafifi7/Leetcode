# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool: # type: ignore
        
        # check if each sub tree is balanced

        def dfs(node):
            if not node:
                return (True, 0)

            left, right = dfs(node.left), dfs(node.right)

            # if left subtree and right subtree balanced 
            #and the difference in height between both subtree is less than or equal to 1
            balanced = (left[0] and right[0] and abs(left[1] - right[1]) <= 1)
            
            return (balanced, 1 + max(left[1], right[1]))


        return dfs(root)[0]
        

