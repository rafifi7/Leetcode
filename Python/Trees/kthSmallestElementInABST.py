# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int: # type: ignore
        # obviously we can put the numbers into a list and sort it and return kth element
        #lets try

        # time complexity is O(n) iterated through entire tree
        # + time complexity of sorting O(nlogn)

        lst = []
        stack = [ root ]

        while stack:
            node = stack.pop()
            lst.append(node.val)

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return sorted(lst)[k - 1]



# actual solution of O(logn) + O(k) where n is the number of nodes and k is the number of nodes until the target

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int: # type: ignore

        # when traversing the tree, the leftmost element with no left node wil be the smallest
        # aka the first element with no left node
        # next smallest will be its parent and the parents right node

        # this is known as in order traversal
        # so we will only add the left elements until no longer possible to our stack then we will 
        # inorder traversal in a bst will give you the numbers in order who would have thought

        n = 0
        stack = []
        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            # this is the smallest value
            cur = stack.pop() 
            n += 1                
            if n == k:
                return cur.val

            cur = cur.right

    

