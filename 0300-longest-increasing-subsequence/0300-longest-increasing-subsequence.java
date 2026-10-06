class Solution {
    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 2];

        // for (int i = 0; i < nums.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        for (int i = nums.length - 1 ; i >= 0; i--) {
            for (int prev = i -1; prev >= -1; prev--) {
                int notTake = dp[i+1][prev+1];

                int take = 0;
                if (prev == -1 || nums[prev] < nums[i]) {
                    take = 1 + dp[i+1][i+1];
                }

                dp[i][prev+1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    // int solve(int[] nums, int i, int prev) {
    //     if (i >= nums.length) return 0;
    //     if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
    //     int notTake = solve(nums, i + 1, prev);

    //     int take = 0;
    //     if (prev == -1 || nums[prev] < nums[i]) {
    //         take = 1 + solve(nums, i + 1, i);
    //     }

    //     return dp[i][prev + 1] = Math.max(take, notTake);
    // }
}
