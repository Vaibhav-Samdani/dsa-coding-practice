/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    static {
        for(int i = 0; i<500;i++){
            connect(new Node(-1));
        }
    }
    public static Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();

            for(int i =0 ; i<len;i++){
                Node temp = q.poll();

                if(i == len-1){
                    temp.next = null;
                }else{
                    temp.next = q.peek();
                }

                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }

        }
        return root;

    }
}