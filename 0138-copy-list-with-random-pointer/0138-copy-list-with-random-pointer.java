/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mp = new HashMap<>();
        Node temp = head;

        Node newNode = new Node(-1);
        Node ans = newNode;

        while (temp != null) {
            newNode.next = new Node(temp.val);
            newNode = newNode.next;
            temp = temp.next;
        }
        temp = head;
        newNode = ans.next;
        while (temp != null) {
            mp.put(temp, newNode);
            temp = temp.next;
            newNode = newNode.next;
        }

        newNode = ans.next;
        temp = head;

        while(newNode != null) {
            Node val = mp.get(temp.random);
            newNode.random = val;
            temp = temp.next;
            newNode = newNode.next;
        }

        return ans.next;
    }
}