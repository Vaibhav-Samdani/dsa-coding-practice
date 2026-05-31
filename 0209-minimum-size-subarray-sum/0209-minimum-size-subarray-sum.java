class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int currSum = 0;
        int ans = Integer.MAX_VALUE;


        for(;j<n;j++){
            currSum += nums[j];

            while(i<=j && currSum >= target){
                ans = Math.min(ans,j-i+1);
                currSum -= nums[i];
                i++;
            }
        }

        return (ans != Integer.MAX_VALUE ? ans : 0);
    }
}