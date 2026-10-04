class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int ans = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans++;
                dfs(isConnected, vis, i);
            }
        }
        return ans;
    }

    void dfs(int[][] isConnected, boolean[] vis, int node) {
        vis[node] = true;

        for (int neigh = 0; neigh < isConnected.length; neigh++) {
            if (isConnected[node][neigh] == 1 && !vis[neigh]) {
                dfs(isConnected, vis, neigh);
            }
        }
    }
}