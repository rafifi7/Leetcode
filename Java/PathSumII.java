// O (n^2) maybe
import java.util.Stack;
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(root.val);
        pathStack.push(new ArrayList<>(Arrays.asList(root.val)));

        List<List<Integer>> result = new ArrayList<>();

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int currentSum = sumStack.pop();
            List<Integer> currentPath = pathStack.pop();

            // If it's a leaf node and the sum matches, add the path to the result
            if (node.left == null && node.right == null && currentSum == targetSum) {
                result.add(new ArrayList<>(currentPath));
            }

            // Process the right child
            if (node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(currentSum + node.right.val);

                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(node.right.val);
                pathStack.push(newPath);
            }

            // Process the left child
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(currentSum + node.left.val);

                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(node.left.val);
                pathStack.push(newPath);
            }
        }

        return result;
    }
}


// O(n) optimal recursive solution 
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        if (root == null) return listOfLists;
        dfs(root, targetSum, 0, new ArrayList<>(), listOfLists);
        return listOfLists;
    }

    public void dfs(TreeNode node, int targetSum, int currSum, List<Integer> path, List<List<Integer>> listOfLists) {
        if (node == null) return;

        // Add the current node to the path and update the current sum
        path.add(node.val);
        currSum += node.val;

        // Check if it's a leaf node and the path sum matches the target
        if (node.left == null && node.right == null && currSum == targetSum) {
            listOfLists.add(new ArrayList<>(path)); // Add a copy of the current path to the result
        }

        // Recur for the left and right children
        dfs(node.left, targetSum, currSum, path, listOfLists);
        dfs(node.right, targetSum, currSum, path, listOfLists);

        // Backtrack: Remove the last node from the path
        path.remove(path.size() - 1);
    }
}
