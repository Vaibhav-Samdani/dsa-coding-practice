class Solution {
    public void floydWarshall(int[][] grid) {
        int n = grid.length;
        int INF = 100000000;

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] == -1)
        //             grid[i][j] = INF;
        //     }
        //     grid[i][i] = 0;
        // }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][via] != INF && grid[via][j] != INF) {
                        grid[i][j] = Math.min(grid[i][j],
                                              grid[i][via] + grid[via][j]);
                    }
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] == INF)
        //             grid[i][j] = -1;
        //     }
        // }
    }
}