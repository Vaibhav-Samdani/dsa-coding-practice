class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

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
				if (helper(vis, adj, i))
					return true;
			}
		}
		
		return false;
		
	}
	
	boolean helper(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int curr) {
		
		Queue<Pair> q = new LinkedList<>();
		
		q.offer(new Pair(curr, -1));
		vis[curr] = true;
		
		
		while (!q.isEmpty()) {
			Pair temp = q.poll();
			int node = temp.node;
			int parent = temp.parent;
			
			ArrayList<Integer> arr = adj.get(node);
			int len = arr.size();
			for (int i = 0; i<len; i++) {
				int val = arr.get(i);
				if (vis[val] && parent != val) {
					return true;
				}
				
				if (!vis[val]) {
					q.offer(new Pair(val,node));
					vis[val] = true;
				}
			}
			
		}
		
		return false;
	}
}
