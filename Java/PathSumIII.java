/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        
        HashMap<Long, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0L, 1);
        return dfs(root, 0L, prefixSums, targetSum);
         
    }
    public int dfs(TreeNode node, long sum, HashMap<Long, Integer> prefixSums, int target) {
        if (node == null) return 0;

        sum += node.val;
        int count = prefixSums.getOrDefault(sum - target, 0);

        prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);

        count += dfs(node.left, sum, prefixSums, target);
        count += dfs(node.right, sum, prefixSums, target);

        prefixSums.put(sum, prefixSums.get(sum) - 1);
        if (prefixSums.get(sum) == 0) {
            prefixSums.remove(sum);
        }

        return count;
    }

    /*stack
    10
    -3 5
    -3 2 3
    -3 2 -2 3
    -3 2 -2
    -3 2
    -3 1
    -3
    11

    int stack:
    10
    7 15
    7 17 18
    7 17 16 21
    7 17 16
    7 17
    7 18
    7
    18

    prefixSums = 
    10 1


    */


}