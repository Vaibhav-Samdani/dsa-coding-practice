class Solution {
    int count = 0;

    public int findCircleNum(int[][] isConnected) {

        boolean[] vis = new boolean[isConnected.length + 1];
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i + 1]) {
                count++;
                helper(i+1, isConnected, vis);
            }
        }
        return count;
    }

    void helper(int curr, int[][] isConnected, boolean[] vis) {
        vis[curr] = true;

        for (int i = 0; i < isConnected[curr-1].length; i++) {
            if (isConnected[curr-1][i] == 1) {
                if (!vis[i + 1]) {
                    helper(i + 1, isConnected, vis);
                }
            }
        }
    }
}