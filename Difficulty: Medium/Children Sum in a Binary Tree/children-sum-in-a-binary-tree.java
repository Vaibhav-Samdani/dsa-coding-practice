/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        
        return hlpr(root);
        
    }
    
    boolean hlpr(Node root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        
        boolean left = hlpr(root.left);
        boolean right = hlpr(root.right);
        
        int leftVal = root.left == null ? 0 : root.left.data;
        int rightVal = root.right == null ? 0 : root.right.data;
        
        return (leftVal + rightVal == root.data) && left && right;
    }
}