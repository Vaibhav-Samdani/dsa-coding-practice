class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,prices,0,0);
    }

    int helper(int[][] dp, int[] prices, int day, int state){
        if(day >= prices.length) return 0;


        if(dp[day][state] != -1) return dp[day][state];

        int profit=0;

        if(state == 0){
            int buy = -prices[day]  + helper(dp,prices,day + 1, 1);
            int notBuy =  helper(dp,prices,day + 1, 0);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[day] + helper(dp,prices,day + 2, 0);
            int notSell = helper(dp,prices,day + 1, 1);

            profit = Math.max(sell,notSell);

        }

        dp[day][state] = profit;

        return profit;
    }
}