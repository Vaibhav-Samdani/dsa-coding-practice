class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev = nums[0];

        int pres = Math.max(nums[1],nums[0]);

        for(int i = 2; i < nums.length;i++){
            int curr = Math.max(pres,nums[i] + prev);
            prev = pres;
            pres = curr;

        }
        
        return pres;
    }

    
}