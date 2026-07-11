class Solution {
    int nodes = 0;
    int degreeSum = 0;

    public int countCompleteComponents(int n, int[][] edges) {

        boolean[] vis = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodes = 0;
                degreeSum = 0;
                dfs(vis, adj, i);
                int edgeCount = degreeSum / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    count++;
                }
            }
        }

        return count;

    }

    void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int curr) {
        vis[curr] = true;

        nodes++;
        degreeSum += adj.get(curr).size();

        for (int i : adj.get(curr)) {
            if (!vis[i]) {
                dfs(vis, adj, i);
            }
        }

    }

}