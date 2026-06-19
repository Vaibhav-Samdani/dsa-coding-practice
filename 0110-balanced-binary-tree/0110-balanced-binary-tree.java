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

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        
        hl(root);

        return res;
        
    }

    int hl(TreeNode root) {
        if (root == null)
            return 0;

        int left = hl(root.left);
        int right = hl(root.right);

        if(Math.abs(right - left) > 1) {
            res = false; 
        }

        return Math.max(left,right) + 1;

    }
}