class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,costs,0);
    }

    int helper(int[] dp, int[] costs, int i) {
        if(i == costs.length) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= 3; jump++){
            int next = i + jump;

            if(next <= costs.length){
                int cost = costs[next-1] + jump*jump;
                ans = Math.min(ans,cost + helper(dp,costs,next));
            }
        }
        return dp[i] = ans;
    }
}