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
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return val; 
    }

    void inorder(TreeNode root, int k) {

        if (root == null || count >= k)
            return ;

        inorder(root.left, k);
        count++;

        if (count == k) {
            val = root.val;
        }

        inorder(root.right,  k);
      
    }
}