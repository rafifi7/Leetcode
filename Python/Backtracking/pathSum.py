# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool: # type: ignore
        

        def backtrack(node, currSum):
            #leaf node
            if not node.left and not node.right:
                if currSum == targetSum:
                    return True

            if node.left:
                if backtrack(node.left, currSum + node.left.val):
                    return True
            if node.right:
                if backtrack(node.right, currSum + node.right.val):
                    return True

            return False

            
        if root:
            return backtrack(root, root.val)
        else:
            return False