// my slow implementation using java stack
import java.util.Stack;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // we can do dfs because we are trying to get the leaf nodes
        Stack<TreeNode> stack1 = new Stack();
        List<Integer> leaves1 = new ArrayList<>();
        stack1.push(root1);

        Stack<TreeNode> stack2 = new Stack();
        stack2.push(root2);

        while (!stack1.isEmpty()) {
            TreeNode currNode = stack1.pop();
            if (currNode.left == null && currNode.right == null) {
                leaves1.add(currNode.val);
            } else {
                if (currNode.right != null) {
                    stack1.push(currNode.right);
                }
                if (currNode.left != null) {
                    stack1.push(currNode.left);
                }
            }
        }

        int i = 0;
        while (!stack2.isEmpty()) {
            TreeNode currNode = stack2.pop();
            if (currNode.left == null && currNode.right == null) {
                if (i > leaves1.size() - 1) { // if the index is ever greater than size - 1
                    return false;
                }
                if (!leaves1.get(i++).equals(currNode.val)) {
                    return false;
                }
            } else {
                if (currNode.right != null) {
                    stack2.push(currNode.right);
                }

                if (currNode.left != null) {
                    stack2.push(currNode.left);
                }
            }
        }
        // check if leaves2 is smaller
        return i == leaves1.size();

    }
}   

//rather than finding all the leaves of one and individually checking
// we can simply keep looking for the next leaf of both
// this saves us memory
import java.util.Stack;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty() ) {
            if ( findNextLeaf(stack1).val != findNextLeaf(stack2).val ) return false;
        }

        if (!stack1.isEmpty() || !stack2.isEmpty()) return false;
        return true;
        

    }

    public TreeNode findNextLeaf(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            if (currNode.left == null && currNode.right == null) return currNode;

            if (currNode.right != null) stack.push(currNode.right);

            if (currNode.left != null) stack.push(currNode.left);

        }
        return null;
    }
}   
