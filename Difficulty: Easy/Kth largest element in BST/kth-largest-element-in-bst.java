/*
class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}
*/
class Solution {
	int ans;
	int count;
	public int kthLargest(Node root, int k) {
		count = 0;
		inodr(root, k);
		return ans;
		
	}
	
	void inodr(Node root, int k) {
		if (root == null)
			return;
		
		inodr(root.right, k);
		count++;
		
		if (count == k) {
			ans = root.data;
			return;
		}
		
		inodr(root.left, k);
	}
	
}
