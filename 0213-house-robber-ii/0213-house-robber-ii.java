class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        int firstVal = solve(dp,nums,0,n-2);

        Arrays.fill(dp,-1);

        int secondVal = solve(dp,nums,1,n-1);

        return Math.max(firstVal,secondVal);
    }

    int solve(int[] dp, int[] nums, int i, int n){
        if(i>n){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + solve(dp,nums,i+2,n);

        int skip = solve(dp,nums,i+1,n);

        return dp[i] = Math.max(take,skip);
    }
}