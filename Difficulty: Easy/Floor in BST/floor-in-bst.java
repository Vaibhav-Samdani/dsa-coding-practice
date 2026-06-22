class Solution {
    public int findMaxFork(Node root, int key) {
        int pre = -1;
        Node curr = root;

        while (curr != null) {
            if (curr.data <= key) {
                pre = curr.data;   // current node is a candidate
                curr = curr.right; // try to find a larger one still < key
            } else {
                curr = curr.left;  // current node and right subtree are >= key
            }
        }

        return pre;
    }
}