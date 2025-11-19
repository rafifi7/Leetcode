# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]: # type: ignore
        
        if not root:
            return 

        # swap each node with its opposite
        tmp = root.left
        root.left = root.right
        root.right = tmp

        # recursive call
        self.invertTree(root.left)
        self.invertTree(root.right)

        return root