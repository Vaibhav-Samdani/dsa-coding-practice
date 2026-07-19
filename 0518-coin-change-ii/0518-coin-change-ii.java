class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 2];

        dp[coins.length][0] = 1;

        for (int i = coins.length-1; i >= 0; i--) {
            dp[i][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                int take = j - coins[i] < 0 ? 0 : dp[i][j - coins[i]];
                dp[i][j] = take + dp[i + 1][j];
            }
        }

        return dp[0][amount];
    }
}
