class Solution {
    public int maxProfit(int[] prices) {
        int curr = 0;
        int max = 0;

        for(int i = 1; i < prices.length; i++){
            curr += prices[i] - prices[i-1];
            curr = Math.max(curr,0);
            max = Math.max(max,curr);
        }

        return max;

    }
}