class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][3][k+1];

        for(int i = 0; i<prices.length;i++){
            for(int j = 0; j<3;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(dp,prices,0,0,k);
    }

    public long helper(long[][][] dp, int[] prices, int day, int state, int k){

        if(day == prices.length && state == 2){
            // return -1;
            return (long)-1e18;
        }
        
        if(day == prices.length || k == 0) return 0;


        if(dp[day][state][k] != -1) return dp[day][state][k];


        long profit = 0;

        if(state == 0){
            // normal transcation
            // buy sell nothing

            long notBuy = helper(dp,prices,day+1,0,k);
            long buy = -prices[day] + helper(dp,prices,day+1,1,k);
            long sell = prices[day] + helper(dp,prices,day+1,2,k);

            profit = Math.max(buy, Math.max(sell,notBuy));

        }else if(state == 1){
            // selling
            // sell nothing
            long notSell = helper(dp,prices,day+1,1,k);
            long sell = prices[day] + helper(dp,prices,day+1,0,k-1);
            profit = Math.max(sell,notSell);
        }else{
            // short selling 
            // buy nothing
            long notBuy = helper(dp,prices,day+1,2,k);
            long buy = -prices[day] + helper(dp,prices,day+1,0,k-1);
            profit = Math.max(buy,notBuy);
        }

        dp[day][state][k] = profit;

        return profit;

    }
}