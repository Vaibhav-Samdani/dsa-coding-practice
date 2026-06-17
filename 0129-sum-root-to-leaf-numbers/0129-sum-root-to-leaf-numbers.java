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
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        helper(list, root, 0);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;

    }

    void helper(List<Integer> list, TreeNode root, int num) {
        if (root == null)
            return;

        num = root.val + num * 10;

        if (root.left == null && root.right == null) {
            list.add(num);
            num /= 10;
            return;
        }

        helper(list, root.left, num);
        helper(list, root.right, num);
        num /= 10;
    }
}