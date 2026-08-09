class Solution {

    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Start BFS from both oceans
        bfs(heights, pacific, true);
        bfs(heights, atlantic, false);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    void bfs(int[][] heights, boolean[][] vis, boolean isPacific) {

        int m = heights.length;
        int n = heights[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Add ocean boundary cells
        if (isPacific) {

            // Top row
            for (int j = 0; j < n; j++) {
                q.offer(new Pair(0, j));
                vis[0][j] = true;
            }

            // Left column
            for (int i = 1; i < m; i++) {
                q.offer(new Pair(i, 0));
                vis[i][0] = true;
            }

        } else {

            // Bottom row
            for (int j = 0; j < n; j++) {
                q.offer(new Pair(m - 1, j));
                vis[m - 1][j] = true;
            }

            // Right column
            for (int i = 0; i < m - 1; i++) {
                q.offer(new Pair(i, n - 1));
                vis[i][n - 1] = true;
            }
        }

        // BFS
        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int i = curr.i;
            int j = curr.j;

            for (int[] dir : dirs) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || ni >= m ||
                    nj < 0 || nj >= n ||
                    vis[ni][nj]) {
                    continue;
                }

                // Reverse water flow
                if (heights[ni][nj] >= heights[i][j]) {

                    vis[ni][nj] = true;
                    q.offer(new Pair(ni, nj));
                }
            }
        }
    }
}