class Solution {
    static int dp[][];
    static int matrixMultiplication(int arr[]) {
        dp = new int[arr.length][arr.length];
        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,1,arr.length-1);
        
    }
    
    static int solve(int[] arr, int i, int j){
        
        if(i==j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k<j ; k++){
            int left = solve(arr,i,k);
            int right = solve(arr,k+1,j);
            
            int cost = arr[i-1] * arr[k] * arr[j];
            
            int totalCost = cost + left + right;
            
            min = Math.min(totalCost, min);
        }
        
        return dp[i][j]=  min;
        
        
    }
}