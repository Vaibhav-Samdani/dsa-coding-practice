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
    HashMap<Integer,Integer> mp;
    int k;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();
        k = 0;

        for(int i = 0; i<preorder.length;i++){
            mp.put(inorder[i],i);
        }

        return helper(preorder,inorder,0,preorder.length-1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int i , int j){
        if(i>j) return null;

        int mid = mp.get(preorder[k++]);

        TreeNode root = new TreeNode(inorder[mid]);

        root.left = helper(preorder,inorder,i,mid-1);
        root.right = helper(preorder,inorder,mid+1,j);

        return root;
    }
}