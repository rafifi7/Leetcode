// O(n) iterative solution
import java.util.Stack;
class Solution {
    public int longestZigZag(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>(); //
        Stack<Character> dirStack = new Stack<>(); //empty is root, l left, r right
        Stack<Integer> countStack = new Stack<>(); // curr Length from that spot


        int maxCount = 0;

        nodeStack.push(root);
        dirStack.push(' ');
        countStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Character dir = dirStack.pop();
            int count = countStack.pop();

            maxCount = Math.max(maxCount, count);


            if (node.right != null) {
                if (dir != 'R') {
                    countStack.push(count + 1);
                }
                else {
                    countStack.push(1);
                }
                nodeStack.push(node.right);
                dirStack.push('R');
            }


            if (node.left != null) {
                if (dir != 'L') 
                    countStack.push(count + 1);
                else {
                    countStack.push(1);
                }
                nodeStack.push(node.left);
                dirStack.push('L');
            }


        }



        return maxCount;


    }
}