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
    void inorder(TreeNode root, ArrayList<TreeNode> temp){
        if(root == null) return;

        inorder(root.left,temp);
        temp.add(root);
        inorder(root.right,temp);
    }

    TreeNode binarySearch(ArrayList<TreeNode> arr, int low, int high){
        if(high < low) return null;

        int mid = low + (high - low)/2;

        arr.get(mid).left = binarySearch(arr,low,mid-1);
        arr.get(mid).right = binarySearch(arr,mid+1,high);
        
        return arr.get(mid);
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> temp = new ArrayList<>();

        inorder(root,temp);

        return binarySearch(temp,0,temp.size()-1);
    }
}