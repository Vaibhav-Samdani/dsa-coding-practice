class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;

        int len = Integer.MIN_VALUE;

        for(int i = 0 ; i<n;i++){
            len = Math.max(len,costs[i]);
        }

        int[] fr = new int[len+1];

        for(int i= 0;i<n;i++){
            fr[costs[i]]++;
        }
        int i = 0;
        int ans = 0;
        while( i <= len && coins >= 0){
            if(coins < i){
                break;
            }
            if(fr[i] <= 0 ){
                i++;
                continue;
            }

            coins -= i;
            fr[i]--;
            ans++;

            if(fr[i] == 0){
                i++;
            }
            
        }

        return ans;

        
    }
}