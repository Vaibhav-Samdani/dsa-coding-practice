class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[n+1];

        Arrays.fill(dp,-1);

        return helper(dp, n,0);
    }

    int helper(int[] dp, int n, int curr) {
        if (curr > n)
            return 0;
        if (curr == n)
            return dp[curr] = 1;

        if(dp[curr] != -1) return dp[curr];

        return dp[curr] = helper(dp, n, curr + 1) + helper(dp, n, curr + 2);

    }
}