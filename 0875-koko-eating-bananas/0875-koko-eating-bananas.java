class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int high = 0;
        
        for(int i = 0; i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        
        int ans = 0;
        high++;
        while(low < high){
            int mid = low + (high-low)/2;
            
            if(isPossible(piles,h,mid)){
                ans = mid;
                high = mid;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }

    static boolean isPossible(int[] nums,int h, int mid){
        
        for(int i = 0; i<nums.length;i++){
            h = h - (nums[i] % mid == 0? nums[i] / mid : (nums[i] / mid)+1);
        }
        
        return h >= 0;
        
    }


}