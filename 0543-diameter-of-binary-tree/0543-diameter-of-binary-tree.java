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

        int left = hl(root.left);
        int right = hl(root.right);

        ans = Math.max(ans, left + right);

        return Math.max(right,left) + 1;
    }
}