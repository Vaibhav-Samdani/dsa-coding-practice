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
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        hl(root);
        return ans;
    }

    int hl(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        int left = hl(root.left);
        int right = hl(root.right);

        int first = 0;
        if (root.left == null || root.right == null) {
            first = left + right + 1;
        } else {
            first = left + right + 2;
        }
        int second = Math.max(right, left) + 1;

        first = Math.max(first, second);

        ans = Math.max(ans, first);

        return second;
    }
}