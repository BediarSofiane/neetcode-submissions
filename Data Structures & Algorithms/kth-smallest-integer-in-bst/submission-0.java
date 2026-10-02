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
   public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        dfs(root, k, new int[1], result);
        return result[0];
    }
        

    private void dfs(TreeNode root, int k, int[] counter, int[] result) {
        if (root == null) {
           return;
        }
        dfs(root.left, k, counter, result);
        counter[0] = counter[0] + 1;
        if (counter[0] > k) {
            return;
        }
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }
        dfs(root.right, k, counter, result);
    }
}
