class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        for(int i = 0 ; i<m;i++){
            for(int j = 0; j<n;j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    helper(grid,i,j);
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i<m;i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }

    void helper(int[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length|| j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0, -1,0,1};
        for(int d = 0; d<4; d++){
            helper(grid,i+dx[d],j+dy[d]);
        }
    }
}