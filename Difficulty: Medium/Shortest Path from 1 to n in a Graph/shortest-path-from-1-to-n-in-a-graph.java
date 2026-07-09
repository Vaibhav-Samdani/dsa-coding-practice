class Solution {
	static class Pair {
		int node;
		int weight;
		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		// 		@Override
		// 		public int compareTo(Pair other) {
		// 			return Integer.compare(this.weight, other.weight);
		// 		}
	}
	public static List<Integer> shortestPath(int n, int m, int edges[][]) {
		
		int V = n + 1;
		
		int src = 1;
		
		int result[] = new int[V];
		int parent[] = new int[V];
		
		Arrays.fill(result, Integer.MAX_VALUE); 
		
		for(int i =0; i<V;i++){
		    parent[i] = i;
		}
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}
		
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a.weight, b.weight));
		
		minHeap.offer(new Pair(src,0));
		
		result[src] = 0;
		
		while(!minHeap.isEmpty()){
		    Pair val = minHeap.poll();
		    
		    int node = val.node;
		    int weight = val.weight;
		    if(weight > result[node]){
		        continue;
		    }
		    for(Pair neigh : adj.get(node)){
		        if(neigh.weight + weight < result[neigh.node]){
		            result[neigh.node] = weight + neigh.weight;
		            parent[neigh.node] = node;
		            minHeap.offer(new Pair(neigh.node, result[neigh.node]));
		        }
		    }
		}
		
		List<Integer> path = new ArrayList<>();
		
		if(result[n] == Integer.MAX_VALUE){
		    path.add(-1);
		    
		    return path;
		}
		
		
		int node = n;
		
		while(parent[node] != node){
		    path.add(node);
		    node = parent[node];
		}
		
		path.add(src);
		
		Collections.reverse(path);
		
		path.add(0, result[n]);
		
		return path;
		
		
	}
}
