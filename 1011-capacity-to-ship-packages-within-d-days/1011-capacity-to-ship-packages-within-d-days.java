class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i<weights.length;i++){
            low = Math.max(low,weights[i]);
            high += weights[i];
        }
        while(low < high){
            int mid = low + (high - low)/2;
            if(canPossible(weights,mid,days)){
                
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    boolean canPossible(int[] weights, int mid, int days){
        int count = 1;
        int curr = 0;
        for(int weight : weights){
            if(curr + weight > mid){
                count++;
                curr = 0;
            }

            curr += weight;
            
        }

        return count <= days;
    }
}