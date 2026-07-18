class Solution {
    int[][] dp; 
    public boolean canCross(int[] stones) {
        dp = new int[stones.length][stones.length];
        
        for(int i = 0; i<stones.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(stones, 1, 0);
    }

    boolean solve(int[] stones, int k, int i) {
        if (i >= stones.length) return false;
        if (i == stones.length - 1) return true;
        if(dp[k][i] != -1) return dp[k][i] == 1;

        if (k <= 0 ) {
            return false;
        }

        int currPos = stones[i];
        int j1 = Arrays.binarySearch(stones, currPos + k - 1);
        int j2 = Arrays.binarySearch(stones, currPos + k);
        int j3 = Arrays.binarySearch(stones, currPos + k + 1);

        boolean t1 = j1 >= 0 && k != 1 ? solve(stones, k - 1, j1) : false;
        boolean t2 = j2 >= 0 ? solve(stones, k, j2) : false;
        boolean t3 = j3 >= 0 && i != 0 ? solve(stones, k + 1, j3) : false;

        if(t1 || t2 || t3){
            dp[k][i] = 1;
        }else{
            dp[k][i] = 0;
        }

        return t1 || t2 || t3;
    }
}
