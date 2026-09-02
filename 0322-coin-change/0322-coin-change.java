class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        dp = new int[coins.length][amount+1];

        for(int i = 0; i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = solve(coins,amount,coins.length-1);

        return ans >= 100_000_000 ? -1: ans;
    }

    int solve(int[] coins, int amount, int i){
        if(amount == 0) return 0;
        if(i<0 || amount < 0) return 100_000_000;

        if(dp[i][amount] != -1) return dp[i][amount];

        int ans = 0;

        int take = 1 + solve(coins,amount-coins[i],i);
        int notTake = solve(coins,amount,i-1);

        return dp[i][amount] = Math.min(take,notTake);
    }
}