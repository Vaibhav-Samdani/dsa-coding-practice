class Solution {

    public boolean isBipartite(int[][] graph) {

        int[] colors = new int[graph.length];

        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 0  -> Red;
    // 1  -> Green;
    // -1 -> Uncolored;
    boolean dfs(int[][] graph, int[] colors, int curr, int currColor) {
        colors[curr] = currColor;

        for (int neighbor : graph[curr]) {
            // 1. Already colored:
            //      - Same color -> return false.
            //      - Different color -> continue.
            // 2. Not colored:
            //      - Assign opposite color and run DFS.

            if (colors[neighbor] != -1) {
                if (colors[neighbor] == currColor)
                    return false;
                continue;
            }

            // (1 - currColor) --> This will change the color
            // Ex. currColor = 1 then for next node 1 - 0 = 1 -> next node's color = 1;
            // And vice versa;
            if (!dfs(graph, colors, neighbor, 1 - currColor)) {
                return false;
            }

        }

        return true;

    }
}
