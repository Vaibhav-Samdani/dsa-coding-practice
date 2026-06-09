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

    ArrayList<TreeNode> arr = new ArrayList();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balanceBSTH(root,0,arr.size()-1); 
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        arr.add(root);
        inorder(root.right);
    }
    public TreeNode balanceBSTH(TreeNode root,int st,int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        root = arr.get(mid);
        root.left = balanceBSTH(root.left,st,mid-1);
        root.right = balanceBSTH(root.right,mid+1,end);

        return root;
    }
}