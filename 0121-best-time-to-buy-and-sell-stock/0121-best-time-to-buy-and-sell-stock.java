class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int curr = 0;
        int minVal = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minVal > prices[i]) {
                minVal = prices[i];
                curr = 0;
            } else {
                curr = prices[i] - minVal;
                ans = Math.max(curr,ans);
            }
        }

        return ans;
    }
}
