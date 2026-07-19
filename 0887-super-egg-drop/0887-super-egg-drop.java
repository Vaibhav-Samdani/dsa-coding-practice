class Solution {
    int[][] dp;
    public int superEggDrop(int e, int f) {
        dp = new int[e+1][f+1];
        for(int i = 0 ; i <= e; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(e,f);
    }

    int solve(int e,int f){
        if(f == 0 || f == 1 || e == 1) return f;
        int ans = Integer.MAX_VALUE;

        if(dp[e][f] != -1) return dp[e][f];

        int left = 1;
        int right = f;

        while(left <= right){
            int mid = left + (right - left)/2;
            int breakIt = solve(e-1,mid-1);
            int notBreak = solve(e,f-mid);

            int temp = 1 + Math.max(breakIt,notBreak);

            ans = Math.min(temp,ans);

            if(breakIt < notBreak){
                left  = mid +1;
            }else{
                right = mid-1;
            }
            
        }


        return dp[e][f] = ans;


    }
}