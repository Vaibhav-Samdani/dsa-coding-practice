class Solution {
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 0 -> startTime, 1 -> endTime, 2 -> profit;

        int[][] interval = new int[startTime.length][3];
        dp = new int[startTime.length];

        Arrays.fill(dp,-1);

        for(int i = 0; i<startTime.length;i++){
            interval[i][0] = startTime[i];
            interval[i][1] = endTime[i];
            interval[i][2] = profit[i];
        }

        Arrays.sort(interval,(a,b) -> Integer.compare(a[0],b[0]));

        return solve(interval,0);

    }

    int solve(int[][] interval, int i){

        if(i>=interval.length) return 0;

        if(dp[i] != -1) return dp[i];
        
        int nextJob = getNextJob(interval,i);
        int take = interval[i][2] + solve(interval,nextJob);
        int notTake = solve(interval,i+1);

        return dp[i] = Math.max(take,notTake);
    }

    int getNextJob(int[][] interval, int i){
        int low = 0, high = interval.length;

        while(low < high){
            int mid = low + (high - low)/2;

            if(interval[mid][0] < interval[i][1]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return low;
    }
}