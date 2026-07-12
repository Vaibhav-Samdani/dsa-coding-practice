class Solution {
	int[] rank;
	int[] parent;
	
	public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		
		rank = new int[V];
		parent = new int[V];
		
		for(int i =0; i<V;i++){
		    parent[i] = i;
		}
		
		for (int u = 0; u < adj.size(); u++) {
			for (int v : adj.get(u)) {
				if (u<v) {
					int u_parent = find(u);
					int v_parent = find(v);
					
					if(u_parent == v_parent) return true;
					
					Union(u,v);
				}
			}
		}
		return false;
	}
	
	int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	void Union(int x, int y) {
		int x_parent = find(x);
		int y_parent = find(y);
		
		if (x_parent == y_parent)
			return;
		
		if (rank[x_parent] > rank[y_parent]) {
			parent[y_parent] = x_parent;
		}
		else if (rank[x_parent] < rank[y_parent]) {
			parent[x_parent] = y_parent;
		} else {
			parent[x_parent] = y_parent;
			rank[y_parent]++;
		}
	}
	
}
