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
    HashMap<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i = 0; i<postorder.length;i++){
            mp.put(inorder[i],i);
        }

        int[] idx = { postorder.length - 1 };

        return helper(inorder,postorder, idx, 0, postorder.length-1);

    }

    TreeNode helper(int[] inorder, int[] postorder, int[] idx, int start, int end) {

        if (start > end)
            return null;

        int rootVal = postorder[idx[0]];

        int i = mp.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        idx[0]--;

        root.right = helper(inorder, postorder, idx, i + 1, end);
        root.left = helper(inorder, postorder, idx, start, i - 1);

        return root;

    }
}