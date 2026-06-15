class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,prices,0,0,fee);
    }

    int helper(int[][] dp, int[] prices, int day, int state, int fee){
        if(day == prices.length) return 0;

        if(dp[day][state] != -1) return dp[day][state];

        int profit=0;

        if(state == 0){
            int buy = -prices[day] - fee + helper(dp,prices,day + 1, 1, fee);
            int notBuy =  helper(dp,prices,day + 1, 0, fee);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[day] + helper(dp,prices,day + 1, 0, fee);
            int notSell = helper(dp,prices,day + 1, 1, fee);

            profit = Math.max(sell,notSell);

        }

        dp[day][state] = profit;

        return profit;
    }
}