class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void Union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                continue;
            } else {
                Union(u, v);
                n--;
            }
        }

        return n - 1;
    }
}
