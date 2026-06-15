class Solution {
    
    public static int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];

        for(int i =0; i<prices.length;i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }


        return helper(dp,prices,0,0,k);
    }

    static int helper(int[][][] dp, int[] prices, int day, int state, int k){
        if(day == prices.length || k==0) return 0;

        if(dp[day][state][k] != -1){
            return dp[day][state][k];
        }

        int profit = 0;

        if(state == 0){
            int buy = -prices[day] + helper(dp,prices,day+1,1,k);
            int notBuy = helper(dp,prices,day+1,0,k);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[day] + helper(dp,prices,day+1,0,k-1);
            int notSell = helper(dp,prices,day+1,1,k);
            profit = Math.max(sell,notSell);
        }
        dp[day][state][k] = profit;
        return profit;
    }
}