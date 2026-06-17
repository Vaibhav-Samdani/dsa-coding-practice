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
    int sum;
    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;

        hl(root);

        return sum;
    }

    int hl(TreeNode root){
        if(root == null) return 0;

        int left = hl(root.left);
        int right = hl(root.right);

        int koi_ek_acha = Math.max(left, right) + root.val;

        int dono_khrab = root.val;

        int sb_shi = left+right+root.val;

        sum = Math.max(sum,Math.max(Math.max(koi_ek_acha,dono_khrab), sb_shi));

        return Math.max(koi_ek_acha,dono_khrab);


    }
}