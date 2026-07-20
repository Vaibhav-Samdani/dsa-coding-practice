/* Definition for Node
class Node
{
	int data;
	Node left;
	Node right;
	Node(int val)
	{
		this.data = val;
		left = null;
		right = null;
	}
}
*/

class Solution {
	ArrayList<ArrayList<Integer>> ans;
	public ArrayList<ArrayList<Integer>> paths(Node root) {
		ans = new ArrayList<>();
		dfs(new ArrayList<>(),root);
		return ans;
		
	}
	
	void dfs(ArrayList<Integer> curr, Node root) {
		if (root == null)
			return;
		curr.add(root.data);
		
		if (root.left == null && root.right == null) {
			ans.add(new ArrayList<>(curr));
		} else {
			dfs(curr, root.left);
			dfs(curr, root.right);
			
		}
		
		curr.remove(curr.size() - 1);
		
	}
}
