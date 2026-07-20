class Solution {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int max = 0;
        // int curr = 0;

        for(int i = 1; i < prices.length; i++){
            int curr = prices[i] - minVal;
            if(curr < 0) curr = 0;
            minVal = Math.min(minVal,prices[i]);
            max = Math.max(max,curr);
        }

        return max;

    }

    // int solve(int[] prices, int i){
    //     if(i == prices.length) return 0;


    // }
}