class Solution {
    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev = nums[0];

        int pres = Math.max(nums[1],nums[0]);

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[1],nums[0]);

        for(int i = 2; i < nums.length;i++){
            int last = pres;
            int curr = nums[i] + prev;

            prev = pres;
            pres = Math.max(last,curr);

        }
        
        return pres;
    }

    
}