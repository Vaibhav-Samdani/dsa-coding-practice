class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        boolean[] vis = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(vis, adj, i);
                count++;
            }
        }

        return count-1;

    }

    void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int curr) {
        vis[curr] = true;

        for (int i : adj.get(curr)) {
            if (!vis[i]) {
                dfs(vis, adj, i);
            }
        }

    }

}