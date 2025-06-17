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
    Map<TreeNode, Integer> depths = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        return true;
    }

    private int maxDepth(TreeNode v) {
        if (v == null)
            return 0;
        if (v.left == null && v.right == null)
            return 1;

        int max_depth = 0;
        if (!depths.containsKey(v)) {
            if (v.left != null)
                max_depth = Math.max(max_depth, maxDepth(v.left));
            if (v.right != null)
                max_depth = Math.max(max_depth, maxDepth(v.right));
            depths.put(v, max_depth + 1);
        }
        return depths.get(v);
    }
}
