class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        dp = new int[arr.length][arr.length];
        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,1,arr.length-1);
    }
    
    static int solve(int[] arr, int i , int j){
        if(j == i) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k < j;k++){
            int c1 = solve(arr,i,k);
            int c2 = solve(arr,k+1,j);
            
            int cost = c1 + c2 + arr[i-1] * arr[k] * arr[j];
            
            min = Math.min(cost,min);
        }
        
        return dp[i][j] = min;
    }
}