class Solution {
    public int climbStairs(int n) {

        if (n == 1 || n == 2 || n == 3)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    int helper(int[] dp, int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
    }
}