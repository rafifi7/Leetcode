//recursive solution
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

//iterative bfs
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while (queue.isEmpty() == false) {
            int levelSize = queue.size();
            level++;    
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
        }
        

        return level;
    }
}


 //iterative dfs
import java.util.Stack;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        int maxDepth = 1;


        while (stack.isEmpty() == false) {
            TreeNode currNode = stack.pop();
            int currDepth = depth.pop();

            if (currNode != null) {
                maxDepth = Math.max(maxDepth, currDepth);

                stack.push(currNode.right);
                depth.push(currDepth + 1);

                stack.push(currNode.left);
                depth.push(currDepth + 1);
            }

        }
        return maxDepth;        
    
    }
}



