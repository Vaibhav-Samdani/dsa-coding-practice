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
    public TreeNode bstToGst(TreeNode root) {
        helper(root,0);
        return root;
    }

    int helper(TreeNode node, int sum){
        // Leetcode - 1038 --> Binary Search Tree to Greater Sum Tree;
        TreeNode root = node;
        if(root == null) return sum;
        sum = helper(root.right,sum);
        sum += root.val;
        root.val = sum;
        sum = helper(root.left,sum);
        return sum;
    }
}