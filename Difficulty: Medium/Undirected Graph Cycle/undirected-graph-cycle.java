class Solution {
	public boolean isCycle(int V, int[][] edges) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (helper(vis, adj, -1, i)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	boolean helper(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int parent, int curr) {

    vis[curr] = true;

    for (int i = 0; i < adj.get(curr).size(); i++) {

        int val = adj.get(curr).get(i);

        if (!vis[val]) {
            if (helper(vis, adj, curr, val)) {
                return true;
            }
        }
        else if (val != parent) {
            return true;
        }
    }

    return false;
}
}
