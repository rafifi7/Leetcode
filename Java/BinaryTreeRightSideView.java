import java.util.Queue; 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // im thinking its going to be we will do a level order traversal but until the queue is empty we don't care about the node
        // nvm dumb idea

        // now im thinking i just add the level as a value in another queue to indicate that
        Queue<Integer> levels = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        ret.add(root.val);
        if (root.right != null) {
            queue.add(root.right);
            levels.add(1);
        }
        if (root.left != null) {
            queue.add(root.left);
            levels.add(1);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int currLevel = levels.poll();
            ret.add(node.val);

            if (node.right != null) { //adding right most nodes first
                queue.add(node.right);
                levels.add(currLevel + 1);
            }
            if (node.left != null) {
                queue.add(node.left);
                levels.add(currLevel + 1);
            }

            while (!levels.isEmpty() && levels.peek() == currLevel) { // loop is here to remove all the remaining node of that level
                levels.poll();
                node = queue.poll();

                if (node.right != null) { //adding right most nodes first
                    queue.add(node.right);
                    levels.add(currLevel + 1);
                }
                if (node.left != null) {
                    queue.add(node.left);
                    levels.add(currLevel + 1);
                }
            }
        }
        return ret;
    }
}