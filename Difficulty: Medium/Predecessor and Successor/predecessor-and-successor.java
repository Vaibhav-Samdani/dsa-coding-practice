/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null;
        Node suc = null;
        Node curr = root;
        
        while(curr != null){
            
            if(curr.data < key){
                pre = curr;
                curr = curr.right;
            }else if(curr.data > key){
                suc = curr;
                curr = curr.left;
            }else{
                Node temp = curr.left;
                while(temp != null){
                    pre = temp;
                    temp = temp.right;
                }
                
                temp = curr.right;
                while(temp != null){
                    suc = temp;
                    temp = temp.left;
                }
                break;
            }
        }
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        
        return ans;
        
    }
}