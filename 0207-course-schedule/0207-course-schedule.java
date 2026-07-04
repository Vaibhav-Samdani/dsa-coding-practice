class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		boolean[] vis = new boolean[V];
		
		int[] indeg = new int[V];
		
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(v).add(u);
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i<adj.size(); i++) {
			for (int val : adj.get(i)) {
				indeg[val]++;
			}
		}
		
		for (int i = 0; i<V; i++) {
			if (indeg[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int u = q.poll();
			
			ans.add(u);
			
			for (int v: adj.get(u)) {
				indeg[v]--;
				
				if (indeg[v] == 0) {
					q.offer(v);
				}
			}
		}

        return ans.size() == V;
		
		// return true;
    }
}