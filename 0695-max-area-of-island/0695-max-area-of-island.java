class Solution {
    int curr = 0;
    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    solve(grid,i,j);
                    max = Math.max(curr,max);
                    curr = 0;
                }
            }
        }

        return max;
    }

    void solve(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        if(grid[i][j] == 0) return;

        curr++;
        grid[i][j] = 0;
        solve(grid, i + 1, j);
        solve(grid, i - 1, j);
        solve(grid, i, j + 1);
        solve(grid, i, j - 1);
    }
}
