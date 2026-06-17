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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list, root,0, targetSum);
        return ans;
    }

    void helper(List<Integer> list, TreeNode root, int sum , int targetSum) {
        if (root == null)
            return;

        sum += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return;
        }


        helper(list, root.left,sum, targetSum);

        helper(list, root.right, sum, targetSum);
        list.remove(list.size()-1);

    }
}