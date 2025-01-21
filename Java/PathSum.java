// iterative solution that uses two stacks sum to keep track of everything
// O(n) time complexity

import java.util.Stack;
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        nodeStack.add(root);
        numStack.add(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int num = numStack.pop();
            
            if (node.left == null && node.right == null) if (num == targetSum) return true;
            
            if (node.right != null) {
                nodeStack.add(node.right);
                numStack.add(node.right.val + num);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                numStack.add(node.left.val + num);
            }
        }
        return false;
    }
}



// recursive solution 
// O(n) dfs
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs (TreeNode node, int currSum, int targetSum) {
        if (node == null) return false;
        currSum += node.val;
        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }

        return dfs(node.right, currSum, targetSum) || dfs(node.left, currSum, targetSum);
        
    }

}