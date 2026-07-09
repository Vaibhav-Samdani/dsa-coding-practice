class Solution {
	
	class Pair {
		int weight;
		int node;
		
		Pair(int n, int w) {
			this.weight = w;
			this.node = n;
		}
		
	}
	
	public int[] dijkstra(int V, int[][] edges, int src) {
		// code here
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
		
		int[] result = new int[V];
		
		Arrays.fill(result, Integer.MAX_VALUE);
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}
		
		minHeap.offer(new Pair(src, 0));
		
		result[src] = 0;
		
		while(!minHeap.isEmpty()) {
			Pair val = minHeap.poll();
			
			int node = val.node;
			int weight = val.weight;
			
			if (weight > result[node]) {
				continue; // This is an outdated entry
			}
			
			for (Pair i : adj.get(node)) {
				if (i.weight + weight < result[i.node]) {
					result[i.node] = i.weight + weight;
					minHeap.offer(new Pair(i.node, result[i.node]));
				}
			}
		}
		
		return result;
		
	}
}
