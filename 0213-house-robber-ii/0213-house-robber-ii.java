class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        if (n <= 3) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(nums[i], ans);
            }

            return ans;
        }

        int first = solve(nums, 0, n - 1);
        Arrays.fill(dp, -1);
        int second = solve(nums, 1, n);

        return Math.max(first, second);
    }

    int solve(int[] nums, int i, int n) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int take = nums[i] + solve(nums, i + 2, n);
        int notTake = solve(nums, i + 1, n);

        return dp[i] = Math.max(take, notTake);
    }
}
