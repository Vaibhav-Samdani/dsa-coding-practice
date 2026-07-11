class Solution {
	class Pair {
		int node;
		int weight;
		
		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	public int spanningTree(int V, int[][] edges) {
		
		boolean[] vis = new boolean[V];
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0 ; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}
		
		int ans = 0;
		
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a.weight, b.weight));
		
		minHeap.offer(new Pair(0, 0));
		
		while (!minHeap.isEmpty()) {
			Pair val = minHeap.poll();
			
			int node = val.node;
			int weight = val.weight;
			
			if(vis[node]) continue;
			
			vis[node] = true;
			ans += weight;
			
			for (Pair v : adj.get(node)) {
				if (!vis[v.node]) {
					minHeap.offer(new Pair(v.node, v.weight));
				}
			}
		}
		
		return ans;
	}
}
