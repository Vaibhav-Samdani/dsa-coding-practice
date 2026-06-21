class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int len = Integer.MIN_VALUE;

        for(int i = 0; i < n;i++ ){
            len = Math.max(len,costs[i]);
        }

        int[] arr = new int[len+1];

        for(int i = 0; i < n;i++){
            arr[costs[i]]++;
        }

        int ans = 0;
        int i = 1;

        while(i <= len){
            if(arr[i] > 0){
                if(coins < i){
                    return ans;
                }
                ans++;
                coins -= i;
                arr[i]--;
            }

            if(arr[i] == 0){
                i++;
            }
            
        }

        return ans;
    }
}