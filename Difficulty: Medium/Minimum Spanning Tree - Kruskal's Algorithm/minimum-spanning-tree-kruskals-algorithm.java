class Solution {
	static int[] parent;
	static int[] rank;
	static int kruskalsMST(int V, int[][] edges) {
		parent = new int[V];
		rank = new int[V];
		for (int i = 0; i<V; i++) {
			parent[i] = i;
		}
		Arrays.sort(edges, (a, b)->Integer.compare(a[2], b[2]));
		int ans = 0;
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			if (find(v) == find(u))
				continue;
			
			ans += w;
			Union(u, v);
			
		}
		
		return ans;
		
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void Union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if (px == py)
			return;
		
		if (rank[px] < rank[py]) {
			parent[px] = py;
		} else if (rank[px] > rank[py]) {
			parent[py] = px;
		} else {
			parent[py] = px;
			rank[px]++;
		}
	}
}
