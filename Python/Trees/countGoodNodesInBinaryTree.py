# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int: # type: ignore
        # idea is to do dfs and have a max ancestor number per node
        stack = [ (root, root.val) ]
        # we will add to our ret list 
        # every time the node.val is not less than its max ancestor
        ret = 0
        while stack:
            node, maxAnc = stack.pop()
            maxAnc = max(maxAnc, node.val)

            if node.val >= maxAnc:
                ret += 1
            
            if node.right:
                stack.append((node.right, maxAnc))
            
            if node.left:
                stack.append((node.left, maxAnc))
            
        return ret