class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curr = 0;

        for(int j = 0; j < nums.length;j++){

            if(nums[j] == 1){
                curr++;
            }else{
                curr = 0;
            }

            ans = Math.max(ans,curr);

        }

        return ans;
    }
}