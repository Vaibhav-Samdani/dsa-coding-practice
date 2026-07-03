class Solution {
	public boolean isCyclic(int V, int[][] edges) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		boolean[] vis = new boolean[V];
		boolean[] isRec = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(u).add(v);
		}
		
		for (int i = 0; i<adj.size(); i++) {
			
			if (!vis[i] && helper(adj, vis, isRec, i))
				return true;
			
		}
		
		return false;
	}
	
	boolean helper(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean isRec[], int curr) {
		vis[curr] = true;
		isRec[curr] = true;
		
		for (int i = 0; i < adj.get(curr).size(); i++) {
			int val = adj.get(curr).get(i);
			if (isRec[val]) {
				return true;
			}
			if (!vis[val]) {
				if (helper(adj, vis, isRec, val))
					return true;
				
			}
		}
		
		isRec[curr] = false;
		
		return false;
	}
}
