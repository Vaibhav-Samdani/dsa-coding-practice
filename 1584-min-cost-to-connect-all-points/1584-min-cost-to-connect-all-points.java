class Solution {
    int[] parent;
	int[] rank;
    class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);

                edges.add(new Edge(i, j, dist));
            }
        }

        	parent = new int[points.length];
		rank = new int[points.length];
		for (int i = 0; i<points.length; i++) {
			parent[i] = i;
		}
		edges.sort((a, b)->Integer.compare(a.wt, b.wt));
		int ans = 0;
		int edgesUsed = 0;
		for (int i = 0; i<edges.size(); i++) {
			int u = edges.get(i).u;
			int v = edges.get(i).v;
			int w = edges.get(i).wt;
			
			if (find(u) != find(v)) {
				ans += w;
				union(u, v);
				edgesUsed++;
				
				if (edgesUsed == points.length - 1)
					break;
			}
			
		}
		
		return ans;


    }

    int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	void union(int x, int y) {
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