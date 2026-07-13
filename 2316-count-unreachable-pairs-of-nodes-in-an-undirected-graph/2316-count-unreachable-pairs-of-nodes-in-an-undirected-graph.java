class Solution {
    int[] parent;
    int[] rank;

    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            Union(u, v);
        }

        for (int i = 0; i < parent.length; i++) {
            int root = find(i);
            mp.put(root, mp.getOrDefault(root, 0) + 1);
        }

        int rem = n;
        long ans = 0;
        // Formula -> size * ( rem - size );
        for (int size : mp.values()) {
            ans += 1L * size * (rem - size);
            rem -= size;
        }

        return ans;

    }

    int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void Union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}