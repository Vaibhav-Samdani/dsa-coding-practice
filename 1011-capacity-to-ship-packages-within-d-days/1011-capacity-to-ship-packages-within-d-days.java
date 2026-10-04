class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;

        int start = Integer.MIN_VALUE;
        int end = 0;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canPossible(weights, mid, days)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;

    }

    boolean canPossible(int[] weights, int capacity, int days) {
        int count = 1;

        int load = 0;

        for(int w : weights){
            if( w + load <= capacity){
                load += w;
            }else{
                load = w;
                count++;
            }
        }

        return  (count <= days) ;


    }
}