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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }

    boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(isSame(root,subRoot)) return true;
        }

        return dfs(root.left,subRoot) || dfs(root.right,subRoot);
    }

    boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q == null) return true;
        if(p==null || q == null) return false;

        return (p.val == q.val) && isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}