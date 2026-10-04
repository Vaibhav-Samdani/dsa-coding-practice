class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                int u = i;
                int v = j;
                if (isConnected[i][j] == 1) {
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        int ans = 0;
        boolean[] vis = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
                ans++;
            }
        }
        return ans;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;

        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                dfs(adj, vis, neigh);
            }
        }
    }
}