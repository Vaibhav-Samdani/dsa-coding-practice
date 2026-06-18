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
    class Node{
        int i;
        TreeNode node;
        Node(int val) { this.i = val; }
        Node(int val, TreeNode node) {
            this.i = val;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = Integer.MIN_VALUE;

        Deque<Node> q = new ArrayDeque<>();

        q.offer(new Node(0,root));

        while (!q.isEmpty()) {
            int len = q.size();

            int first = q.peekFirst().i;
            int last = q.peekLast().i;

            maxWidth = Math.max(maxWidth, last - first +1);

            for (int i = 0; i < len; i++) {
                Node temp = q.poll();
                int j = temp.i;
                if (temp.node.left != null) {
                    q.offer(new Node(2*j,temp.node.left));
                }
                if (temp.node.right != null) {
                    q.offer(new Node(2*j+1,temp.node.right));
                } 
            }
        }

        return maxWidth;

    }

}