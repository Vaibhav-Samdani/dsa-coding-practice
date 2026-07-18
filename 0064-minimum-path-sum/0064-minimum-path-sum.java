class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(grid, 0, 0);
    }

    int solve(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[i].length) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];


        int down = solve(grid, i + 1, j);
        int right = solve(grid, i, j + 1);

        return dp[i][j] = grid[i][j] + Math.min(right,down);
    }
}
