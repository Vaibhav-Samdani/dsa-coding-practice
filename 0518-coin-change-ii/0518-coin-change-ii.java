class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];

        for(int i = 0; i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(amount,coins,0);
    }

    int solve(int amount, int[] coins, int i){
        if(i == coins.length) return 0;
        if(amount < 0){
            return 0;
        }
        if(amount == 0) return 1;

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = solve(amount-coins[i],coins,i);
        int skip = solve(amount,coins,i+1);

        return dp[i][amount] = take+skip;
    }
}