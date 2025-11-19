# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int: # type: ignore
        # i think the longest path would always be between the deepest node of left side and deepest node of right side

        # so if it was 1
        #           2
        #       3       4
        #    5    6   7   8
        #  9   10       11  12

        # returns height of node
        self.res = 0

        def dfs(curr):

            # Returns height
            if not curr:
                return 0

            left = dfs(curr.left)
            right = dfs(curr.right)

            self.res = max(self.res, left + right)

            return max(left, right) + 1

        dfs(root)
        return self.res