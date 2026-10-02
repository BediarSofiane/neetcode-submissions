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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        int min = (int) Math.min(q.val, p.val);
        int max = (int) Math.max(q.val, p.val);
        while (current != null) {
            if (current.val == p.val || current.val == q.val || current.val < max && current.val > min) {
                return current;
            } else {
                if (current.val > p.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
        return root;
    }
}
