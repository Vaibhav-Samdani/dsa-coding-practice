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
    HashMap<Integer, Integer> mp ;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        mp = new HashMap<>();
        int idx = 0;

       for(int i = 0 ; i<n;i++){
        mp.put(inorder[i],i);
       }

        return solve(preorder, inorder, 0, n-1);
    }

    TreeNode solve(int[] preorder, int[] inorder, int start, int end){
        if(start > end ) return null;
        
        int index = idx;
        int rootVal = preorder[index];
        int i = mp.get(rootVal) ;


        idx++;

        TreeNode root = new TreeNode(rootVal);

        root.left = solve(preorder, inorder, start, i-1);
        root.right = solve(preorder, inorder, i+1, end);

        return root;
    }

}