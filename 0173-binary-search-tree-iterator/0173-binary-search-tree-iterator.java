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
class BSTIterator {

    Stack<TreeNode> st;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        addAll(root);
        curr = st.peek();

    }
    
    public int next() {
        if(st.isEmpty()) return -1;
        TreeNode val = st.pop();
        curr = st.isEmpty() ? null : st.peek();
        return val.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    // Helpers
    public void addAll(TreeNode root){
        if(root == null) return;
        addAll(root.right);
        st.push(root);
        addAll(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */