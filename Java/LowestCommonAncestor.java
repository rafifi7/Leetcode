// iterative solution O(n)

// we start by running dfs using a stack, we keep track of the current path at each node we get to by creating a new arraylsit and adding the new node to it. 
// then we add the arraylist to our stack when we add the new node to the stack.
// once we find q and p nodes, we break out of the loop and add all the nodes to get to p into a hashset
// then we iterate backwords through the q path to find the lowest common ancestor

import java.util.Stack;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<ArrayList<Integer>> pathStack = new Stack<>();
        ArrayList<Integer> qPath = new ArrayList<>();
        ArrayList<Integer> pPath = new ArrayList<>();

        nodeStack.add(root);
        ArrayList firstNode = new ArrayList<Integer>();
        firstNode.add(root.val);
        pathStack.add(firstNode);

        boolean pFound = false;
        boolean qFound = false;

        // im thinking we can do while pFound == false and qFound == false then i can do an if p is not found yet

        while (!nodeStack.isEmpty()) { // while p is not found yet and q is not found yet but if they are both found then exit loop
            TreeNode node = nodeStack.pop();
            ArrayList<Integer> currPath = pathStack.pop();

            if (!pFound) {
                if (node.val == p.val) {
                    pPath = currPath;
                    pFound = true;
                }
            }
            if (!qFound)  {
                if (node.val == q.val) {
                    qPath = currPath;
                    qFound = true;
                }
            }

            if (pFound && qFound) {
                break;
            }

            if (node.right != null) {
                nodeStack.add(node.right);
                ArrayList<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(node.right.val);
                pathStack.push(newPath);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                ArrayList<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(node.left.val);
                pathStack.push(newPath);
            }
        }



        // add one path to a hashset then iterate backwards through other path 
        // return first val that is in hashset
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < pPath.size(); i++) {
            hs.add(pPath.get(i));
        }
        TreeNode ret = null;
        for (int i = qPath.size() - 1; i > -1; i--) {
            if (hs.contains(qPath.get(i))) {
                ret = new TreeNode(qPath.get(i));
                break;
            }
        }

        return ret;
    }
}