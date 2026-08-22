class Solution {
	
	
	int[] parent;
	
	public int spanningTree(int V, int[][] edges) {
		
		parent = new int[V];
		int ans = 0;
		
		for(int i = 0; i < V;i++){
		    parent[i] = i;
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
		
		for (int i = 0; i < edges.length; i++) {
			pq.offer(edges[i]);
		}
		
	
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			int pu = find(curr[0]);
			int pv = find(curr[1]);
			int weight = curr[2];
			
			if(pu == pv){
			    continue;
			}else{
			    union(curr[0],curr[1]);
			    ans += weight;
			}
			
		}
		
		return ans;
	}
	
	int find(int x){
	    if(x == parent[x]) return x;
	    
	    return parent[x] = find(parent[x]);
	}
	
	
	void union(int x, int y){
	    int px = find(x);
	    int py = find(y);
	    if(px != py) {
	        parent[px] = py;
	    }
	}
	
	
}
