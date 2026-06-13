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
    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,0,k);
        return val; 
    }

    int inorder(TreeNode root, int i, int k) {

        if (root == null)
            return 0;

        int a = inorder(root.left, i, k);
        i += a;

        if (i+1 == k) {
            val = root.val;
        }

        int b = inorder(root.right, i+1, k);
        i += b;


        return a + b + 1;
    }
}