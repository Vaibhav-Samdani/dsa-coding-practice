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
    public void flatten(TreeNode root) {
        
        toLLHelper(root);
        
    }

    void toLLHelper(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            TreeNode right = root.right;
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            root.right = root.left;
            root.left = null;
            temp.right = right;
        }
        if (root.right != null)
            toLLHelper(root.right);
    }
}