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

        if (px == py)
            return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String s : equations) {
            char[] val = s.toCharArray();

            if (val[1] == '=') {
                Union(val[0] - 'a', val[3] - 'a');
            }
        }
        for (String s : equations) {
            char[] val = s.toCharArray();

            if (val[1] == '!') {
                if (find(val[0] - 'a') == find(val[3] - 'a')) {
                    return false;
                }
            }
        }

        return true;

    }
}