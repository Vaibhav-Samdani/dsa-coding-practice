class Solution {
    boolean[][] dp;

    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (n > 1 && stones[1] != 1)
            return false;
        dp = new boolean[n][n + 1];

        for (int k = 0; k <= n; k++)
            dp[n - 1][k] = true;
    

        for (int i = n-2; i >= 1; i--) {
            for (int j = 1; j < n; j++) {
                
                int currPos = stones[i];
                int j1 = Arrays.binarySearch(stones, currPos + j - 1);
                int j2 = Arrays.binarySearch(stones, currPos + j);
                int j3 = Arrays.binarySearch(stones, currPos + j + 1);

                boolean t1 = j1 >= 0 && j != 1 ? dp[j1][j-1] : false;
                boolean t2 = j2 >= 0 ? dp[j2][j] : false;
                boolean t3 = j3 >= 0 ? dp[j3][j+1] : false;

                dp[i][j] = t1 || t2 || t3;

            }
        }

        return dp[1][1];
    }
}
