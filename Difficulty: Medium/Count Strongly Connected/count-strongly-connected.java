class Solution {
	// Function to find number of strongly connected components in the graph
	public int kosaraju(int V, int[][] edges) {
		// 0. Convert edges into adj list;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(u).add(v);
		}
		
		// 1. Topological Sorted Stack;
		
		// 		Stack<Integer> st = new ArrayDeque<>();
		Deque<Integer> st = new ArrayDeque<>();
		
		for (int i = 0; i<V; i++) {
			if (!vis[i]) {
				dfs(adj, vis, st, i);
			}
		}
		
		// 2. Reverse the nodes
		for (ArrayList<Integer> neighbors : adj) {
			neighbors.clear();
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(v).add(u);
		}
		
		// 3. Run DFS in the order of Stack;
		Arrays.fill(vis,false);
		int count = 0;
		while(!st.isEmpty()){
		    int val = st.pop();
		    if(!vis[val]){
		        dfs(adj,vis,val);
		        count++;
		    }
		}
		
		return count;
		
	}
	
	void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,Deque<Integer> st, int curr) {
		vis[curr] = true;
		
		for (int i = 0; i < adj.get(curr).size(); i++) {
			int val = adj.get(curr).get(i);
			
			if (!vis[val]) {
				dfs(adj, vis, st, val);
			}
		}
		
		st.push(curr);
	}
	void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
		vis[curr] = true;
		
		for (int i = 0; i < adj.get(curr).size(); i++) {
			int val = adj.get(curr).get(i);
			
			if (!vis[val]) {
				dfs(adj, vis, val);
			}
		}
		
	}
}
