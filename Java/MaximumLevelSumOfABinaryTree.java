//iterative solution using 2 queues
// one queue to iterate through the tree and another queue to keep track of the current level of each node as we traverse
import java.util.Queue;
class Solution {
    public int maxLevelSum(TreeNode root) {
        int currMax = Integer.MIN_VALUE;
        int maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int currLevel = levels.poll();
            int sum = node.val;

            if (node.left != null) {
                queue.add(node.left);
                levels.add(currLevel + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levels.add(currLevel + 1);
            }

            if (levels.isEmpty()) {
                if (currMax < sum) {
                    currMax = sum;
                    maxLevel = currLevel;
                }
            } else {
                // if levels is not empty
                while (!levels.isEmpty() && levels.peek() == currLevel) {
                    node = queue.poll();
                    sum += node.val;
                    levels.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                        levels.add(currLevel + 1);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        levels.add(currLevel + 1);
                    }
                }
                if (currMax < sum) {
                    currMax = sum;
                    maxLevel = currLevel;
                }
            }
        }
        return maxLevel;
    }    
}