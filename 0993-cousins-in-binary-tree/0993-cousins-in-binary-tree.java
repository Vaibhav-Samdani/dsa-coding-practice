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

    boolean isSibling(TreeNode node, int x, int y) {
    if (node == null) {
        return false;
    }

    if (node.left != null && node.right != null) {
        if ((node.left.val == x && node.right.val == y) ||
            (node.left.val == y && node.right.val == x)) {
            return true;
        }
    }

    return isSibling(node.left, x, y) || isSibling(node.right, x, y);
}

    public boolean isCousins(TreeNode root, int x, int y) {
        // 993. Cousins in Binary Tree

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        boolean fi = false;
        boolean se = false;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode temp = q.poll();

                if (temp.val == x) {
                    fi = true;
                }
                if (temp.val == y) {
                    se = true;
                }

                if (fi && se) {
                    break;
                }

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }

            }

            if (fi && se)
                break;

            fi = false;
            se = false;
        }

        return !isSibling(root, x, y) && fi && se;

    }
}