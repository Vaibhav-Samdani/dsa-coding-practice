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
    public int goodNodes(TreeNode root) {
        ans = 0;
        dfs(root,Integer.MIN_VALUE);
        return ans;
    }

    void dfs(TreeNode root, int i){
        if(root == null) return;

        if(root.val >= i) ans++;

        dfs(root.left,Math.max(i,root.val));
        dfs(root.right,Math.max(i,root.val));
    }
}