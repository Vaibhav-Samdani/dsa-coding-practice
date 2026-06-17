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
    List<String> list;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        order(new StringBuilder(), root);

        return list;
    }

    void order(StringBuilder s, TreeNode root) {
        if (root == null)
            return;

        int len = s.length();

        s.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(s.toString());
            
            s.setLength(len);
            return;

        }

        s.append("->");

        order(s, root.left);
        order(s, root.right);

        s.setLength(len);
    }
}