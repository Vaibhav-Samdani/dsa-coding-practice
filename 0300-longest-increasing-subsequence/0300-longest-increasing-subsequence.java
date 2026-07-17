class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n][n+1];

        for(int i = 0; i<dp.length;i++){
Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,-1);
    }

    int solve(int[] arr, int i, int prev){
        if(arr.length == i) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int skip = solve(arr,i+1,prev);

        int take = 0;

        if(prev == -1 || arr[i] > arr[prev]){
            take = 1 + solve(arr,i+1,i);
        }

        return dp[i][prev+1] = Math.max(skip,take);
    }
}