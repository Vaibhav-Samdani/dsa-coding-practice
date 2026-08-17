class Solution {
	class Pair {
		int node;
		int dis;
		Pair(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}
	}
	
	public int spanningTree(int V, int[][] edges) {
		
		int ans = 0;
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
			adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
		}
		
		boolean[] vis = new boolean[V];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.dis, b.dis));
		
		pq.offer(new Pair(0, 0));
		
// 		vis[0] = true;
		
		while (!pq.isEmpty()) {
			Pair node = pq.poll();
			
			if (vis[node.node]) {
				continue;
			}
			vis[node.node] = true;
			ans += node.dis;
			
			for (Pair neigh : adj.get(node.node)) {
				if (!vis[neigh.node]) {
					pq.offer(new Pair(neigh.node, neigh.dis));
				}
				
			}
		}
		
		return ans;
	}
}
