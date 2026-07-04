class Solution {
	public ArrayList<Integer> topoSort(int V, int[][] edges) {
		// code here
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(u).add(v);
		}
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i<adj.size(); i++) {
			if (!vis[i]) {
				dfs(vis, adj, i,st);
				// st.push(i);
			}
			
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while (!st.isEmpty()) {
			ans.add(st.pop());
		}
		
		return ans;
		
	}
	
	void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int curr,Stack<Integer> st) {
		vis[curr] = true;
		
		for (int i = 0; i<adj.get(curr).size(); i++) {
			int val = adj.get(curr).get(i);
			if (!vis[val]) {
				dfs(vis, adj, val,st);
			}
		}
		
		st.push(curr);
	}
	
}
