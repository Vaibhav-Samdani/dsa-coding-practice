class Solution {
	class Pair {
		int dis;
		int node;
		Pair(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}
	}
	public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}
		
		int[] result = new int[V];
		
		Arrays.fill(result, Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> Integer.compare(a.dis, b.dis));
		
		pq.offer(new Pair(src, 0));
		result[src] = 0;
		
		while (!pq.isEmpty()) {
			Pair node = pq.poll();
			
			if (node.dis > result[node.node])
				continue;
			
			for (Pair neigh : adj.get(node.node)) {
				if (result[neigh.node] > node.dis + neigh.dis) {
					result[neigh.node] = node.dis + neigh.dis;
					pq.offer(new Pair(neigh.node, result[neigh.node]));
					
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int x : result) {
			list.add(x);
		}
		
		return list;
		
	}
}
