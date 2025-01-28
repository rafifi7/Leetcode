//iterative solution
import java.util.Stack;
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // run dfs based on values
        Stack<TreeNode> stack = new Stack<>();
 
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (val > node.val) {
                if (node.right != null) {
                    stack.add(node.right);
                } else {
                    return null;
                }
            } else if (val < node.val) {
                if (node.left != null) {
                    stack.add(node.left);
                } else {
                    return null;
                }
            } else {// if equal
                return node;
            }
        }
        return null;
    }
}