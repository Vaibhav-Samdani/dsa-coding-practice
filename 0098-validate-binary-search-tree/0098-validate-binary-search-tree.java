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

    boolean isBST(TreeNode node,long max, long min){
        if(node == null) return true;
        if(max <= node.val || min >= node.val) return false;
        
        return isBST(node.left, node.val,min) && isBST(node.right, max,node.val);        
    }

    public boolean isValidBST(TreeNode root) {
        
        return isBST(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }
}