# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#This solution does dfs on tree and creates a set of ancestors for each node, by adding itself to the previous node's ancestor set
# Then at the end we check look for the largest depth of the common ancestors sets

# O(n) + O(log(n)) where n is number of nodes

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode': # type: ignore
        # so im thinking we can have a hashmap where each node points to a set of tuples of ancestors, height
        stack = [root]
        nodeToTup = {}
        rootSet = set()
        rootSet.add(root)
        nodeToTup[root.val] = (rootSet,  1)

        while stack:
            node = stack.pop()

            if node.left:
                stack.append(node.left)
                # make copy of set of ancestor nodes
                leftSet = nodeToTup[node.val][0].copy()
                # add to list of ancestornodes
                leftSet.add(node.left)
                # add new set to be value of key
                nodeToTup[node.left.val] = (leftSet, nodeToTup[node.val][1] + 1)

            if node.right:
                stack.append(node.right)
                # get set of ancestor nodes
                rightSet = nodeToTup[node.val][0].copy()
                # add to list of ancestor nodes because node can be own ancestor
                rightSet.add(node.right)
                # val is now connected to the list of ancestor nodes and height of itself
                nodeToTup[node.right.val] = (rightSet, nodeToTup[node.val][1] + 1)

        pSet, pHeight = nodeToTup[p.val]
        qSet, qHeight = nodeToTup[q.val]

        maxHeight = -1
        lca = None

        smallSet = pSet if len(pSet) > len(qSet) else qSet
        largeSet = qSet if len(pSet) > len(qSet) else pSet

        for num in smallSet:
            # check if qSet in there and if height is larger, meaning its further down
            if num in largeSet and maxHeight < nodeToTup[num.val][1]:
                lca = num
                maxHeight = nodeToTup[num.val][1]
        
        return lca
        

# Faster solution by doing similar thing but instead only searching for paths of p and q because others are not necessary
# O(max(q path length, p path length)) + O(min(q path length, p path length))
# so realistically its O(q path length) + O(p path length)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode': # type: ignore
        # so im thinking we can have a hashmap where each node points to a set of tuples of ancestors, height
        qSet = set()
        pSet = set()

        qList = []
        pList = []

        qList.append(root)
        pList.append(root)
        qSet.add(root)
        pSet.add(root)

        node = root
        node2 = root
        # lets find p and q
        while node.val != p.val and node2.val != q.val:
            if node.val != p.val:
                if p.val > node.val:
                    pSet.add(node.right)
                    pList.append(node.right)
                    node = node.right
                elif p.val < node.val:
                    pList.append(node.left)
                    pSet.add(node.left)
                    node = node.left


            if node2.val != q.val:
                if q.val > node2.val:
                    qList.append(node2.right)
                    qSet.add(node2.right)
                    node2 = node2.right

                elif q.val < node2.val:
                    qList.append(node2.left)
                    qSet.add(node2.left)
                    node2 = node2.left
                

        maxHeight = -1

        smallList = pList if len(qList) > len(pList) else qList
        largeSet = qSet if len(qSet) > len(pSet) else pSet

        for num in smallList[::-1]:
            if num in largeSet:
                return num
                
        

