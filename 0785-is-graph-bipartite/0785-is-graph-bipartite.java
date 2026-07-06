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

    // 0 for Red, 1 for Green and -1 : Nothing;
    boolean dfs(int[][] graph, int[] colors, int curr, int currColor) {
        colors[curr] = currColor;

        for (int i = 0; i < graph[curr].length; i++) {
            // 1. color phle s ho
            //  1.1 same color phle s ho --> Continue for the next;
            //  1.2 currColor s dusra color ho   --> return false;
            // 2. color phle s na ho --> assign the color means move for the next;
            int val = graph[curr][i];
            if (colors[val] == -1) {
                int color = 1 - currColor;
                if (!dfs(graph, colors, val, color)) {
                    return false;
                }
            } else {
                if (colors[val] == currColor) {
                    return false;
                } else {
                    continue;
                }
            }

        }

        return true;

    }
}
