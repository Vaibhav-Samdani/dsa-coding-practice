/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int key) {
        int pre = -1;
        Node curr = root;

        while (curr != null) {
            if (curr.data < key) {
                curr = curr.right; // try to find a larger one still < key
            } else {
                pre = curr.data;   // current node is a candidate
                curr = curr.left;  // current node and right subtree are >= key
            }
        }

        return pre;
        
    }
}